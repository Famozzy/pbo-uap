package pbo.praktikum;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BentukForm extends JFrame {
    private JPanel FormPanel;
    private JTextField txt_angka1;
    private JTextField txt_angka2;
    private JButton btn_hitung;
    private JButton btn_reset;
    private JButton btn_tutup;
    private JTextArea txtarea_hasil;

    BentukForm() {
        initComponents();


        btn_hitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txt_angka1.getText().isEmpty() || txt_angka2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Angka tidak boleh kosong",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
                double a = Double.parseDouble(txt_angka1.getText());
                double b = Double.parseDouble(txt_angka2.getText());
                Bentuk[] Bentuks = {
                        new BentukPersegiPanjang(),
                        new BentukJajarGenjang(),
                        new BentukSegitiga(),
                        new BentukLayangLayang(),
                        new BentukBelahKetupat()
                };
                polimorfisme(Bentuks, a, b);
            }
        });


        btn_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetText();
            }
        });

        btn_tutup.addActionListener(new ActionListener() {
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
    }

    private void resetText() {
        txt_angka1.setText("");
        txt_angka2.setText("");
        txtarea_hasil.setText("");
    }

    private void polimorfisme(Bentuk[] B, double a, double b) {
        String hasil = "";
        for (int i = 0; i < B.length; i++) {
            B[i].setA(a);
            B[i].setB(b);
            B[i].setC();
            hasil += B[i].cetak() + "\n";
        }

        txtarea_hasil.setText(hasil);
        String namaAktifitas = "LUAS BENTUK";
        new Bentuk().logAktifitas(Session.getUserId(), namaAktifitas, hasil);
    }

    private void initComponents() {
        setTitle("Luas Bentuk");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(FormPanel);
        pack();
        setLocationRelativeTo(null);
    }
}
