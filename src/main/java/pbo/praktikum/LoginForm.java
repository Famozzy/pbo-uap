package pbo.praktikum;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JPanel LoginPanel;
    private JButton btn_keluar;
    private JTextField txt_userid;
    private JTextField txt_password;
    private JButton btn_login;
    private JButton btn_reset;

    LoginForm() {
        initComponent();

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
                    System.exit(0);
                }
            }
        });

        btn_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_userid.setText("");
                txt_password.setText("");
            }
        });

        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Login loginHandler = new Login();
                    String userId = txt_userid.getText();
                    String password = txt_password.getText();
                    if (userId.trim().isEmpty() || password.trim().isEmpty()) {
                        throw new Exception("User ID dan Password tidak boleh kosong");
                    }
                    String loginMsg = loginHandler.cekLogin(userId, password);
                    if (loginMsg.equals("OK")) {
                        new Menu().setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                loginMsg,
                                "Informasi",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }

    private void initComponent() {
        this.setTitle("Login Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setContentPane(LoginPanel);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}
