package pbo.praktikum;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.ResultSet;

public class FormSiswa extends JFrame {
    private JPanel panel;
    private JTextField txt_id;
    private JTextField txt_alamat;
    private JTable tabel_siswa;
    private JButton btn_simpan;
    private JButton btn_reset;
    private JButton btn_ubah;
    private JButton btn_hapus;
    private JButton btn_keluar;
    private JTextField txt_nama;
    private JScrollPane ScrollPane;
    private JTextField txt_pencarian;
    private JButton btn_cari;
    private JButton btn_semuadata;

    private final CRUD db = new CRUD();
    private final DefaultTableModel tableModel = new DefaultTableModel(
            null, new Object[] {"ID", "Nama", "Alamat"}
    );

    FormSiswa() throws SQLException {
        initComponents();
        tampilDatabase(null);

        btn_keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah Anda yakin akan keluar ?",
                        "Warning",
                        JOptionPane.YES_NO_OPTION
                );
                if (option == JOptionPane.YES_OPTION) {
                    new Menu().setVisible(true);
                    dispose();
                }
            }
        });

        btn_simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validasiForm();
                    String resultMsg = db.simpanData(txt_id.getText(), txt_nama.getText(), txt_alamat.getText());
                    tampilDatabase(null);
                    resetText();
                    informationDialog(resultMsg);
                } catch (Exception ex) {
                    informationDialog(ex.getMessage());
                    System.out.println(ex);
                }
            }
        });

        btn_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetText();
            }
        });

        btn_ubah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validasiForm();
                    String resultMsg = db.ubahData(txt_id.getText(), txt_nama.getText(), txt_alamat.getText());
                    tampilDatabase(null);
                    resetText();
                    informationDialog(resultMsg);
                } catch (Exception ex) {
                    informationDialog(ex.getMessage());
                    System.out.println(ex);
                }
            }
        });

        tabel_siswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tabel_siswa.getSelectedRow();
                txt_id.setText(tabel_siswa.getValueAt(row, 0).toString());
                txt_nama.setText(tabel_siswa.getValueAt(row, 1).toString());
                txt_alamat.setText(tabel_siswa.getValueAt(row, 2).toString());
            }
        });

        btn_hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(txt_id.getText().trim().isEmpty()) {
                        throw new Exception("ID belum diisi !");
                    }
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Apakah Anda yakin akan menghapus data ini ?",
                            "Warning",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (confirm == JOptionPane.YES_OPTION) {
                        String resultMsg = db.hapusData(txt_id.getText());
                        tampilDatabase(null);
                        informationDialog(resultMsg);
                        resetText();
                    } else {
                        System.out.println("Data tidak dihapus");
                    }
                } catch (Exception ex) {
                    informationDialog(ex.getMessage());
                    System.out.println(ex);
                }
            }
        });

        btn_semuadata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tampilDatabase(null);
                } catch (SQLException ex) {
                    System.out.println(ex.toString());
                }
            }
        });

        btn_cari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(txt_pencarian.getText().trim().isEmpty()) {
                        throw new Exception("Kata kunci belum diisi !");
                    }
                    String query = txt_pencarian.getText();
                    ResultSet hasilCari = db.cariData(query);
                    tampilDatabase(hasilCari);
                } catch (Exception ex) {
                    informationDialog(ex.getMessage());
                    System.out.println(ex);
                }
            }
        });
    }

    private void tampilDatabase(ResultSet data) throws SQLException {
        try {
            if(data == null) data = db.tampilData();
            tableModel.setRowCount(0);
            while (data.next()) {
                tableModel.addRow(new String[]{
                        data.getString("id"),
                        data.getString("nama"),
                        data.getString("alamat")
                });
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void validasiForm() throws Exception {
        if (txt_id.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Maaf, ID belum diisi !");
            throw new Exception("ID belum diisi !");
        } else if (txt_nama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Maaf, Nama belum diisi !");
            throw new Exception("Nama belum diisi !");
        } else if (txt_alamat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Maaf, Alamat belum diisi !");
            throw new Exception("Alamat belum diisi !");
        }
    }

    private void informationDialog(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                "Informasi",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    private void resetText() {
        txt_id.setText("");
        txt_nama.setText("");
        txt_alamat.setText("");
    }

    private void initComponents() {
        this.setTitle("Form Siswa");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        tabel_siswa.setModel(tableModel);
    }
}
