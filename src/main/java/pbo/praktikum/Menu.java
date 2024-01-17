package pbo.praktikum;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Menu extends JFrame {
    private JPanel MenuPanel;
    private JLabel greeting;
    JMenuItem menuLogout = new JMenuItem("Logout");
    JMenuItem menuSiswa = new JMenuItem("Siswa");
    JMenuItem menuBentuk = new JMenuItem("Bentuk");

    Menu() {
        initComponent();

        String username = Session.getNama();
        greeting.setText("Selamat Datang Kembali, " + username);

        menuLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Login loginHandler = new Login();
                    int option = JOptionPane.showConfirmDialog(
                            null,
                            "Apakah Anda yakin akan logout ?",
                            "Warning",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (option == JOptionPane.YES_OPTION) {
                        loginHandler.logout();
                        new LoginForm().setVisible(true);
                        dispose();
                    }

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    dispose();
                }
            }
        });

        menuSiswa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new FormSiswa().setVisible(true);
                    dispose();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        menuBentuk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new BentukForm().setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }


    private void initComponent() {
        setTitle("Aplikasi Data Siswa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(MenuPanel);
        pack();
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuAplikasi = new JMenu("Aplikasi");
        JMenu menuCrud = new JMenu("CRUD");
        JMenu menuPolimorfisme = new JMenu("Polimorfisme");

        setJMenuBar(menuBar);
        menuBar.add(menuAplikasi);
        menuBar.add(menuCrud);
        menuBar.add(menuPolimorfisme);
        menuAplikasi.add(menuLogout);
        menuCrud.add(menuSiswa);
        menuPolimorfisme.add(menuBentuk);
    }
}
