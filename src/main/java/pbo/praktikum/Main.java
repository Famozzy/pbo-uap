package pbo.praktikum;

public class Main {
    public static void main(String[] args) {
        try {
//            new FormSiswa().setVisible(true);
            new LoginForm().setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}