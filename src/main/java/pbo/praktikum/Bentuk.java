package pbo.praktikum;

import java.sql.Connection;
import java.sql.PreparedStatement;


interface ILogAkttifitas {
    void logAktifitas(String userID, String aktifitas, String keterangan);
}

public class Bentuk extends BaseBentuk implements ILogAkttifitas {
    protected double getA() {
        return a;
    }

    protected double getB() {
        return b;
    }

    protected double getC() {
        return c;
    }

    protected void setA(double a) {
        this.a = a;
    }

    protected void setB(double b) {
        this.b = b;
    }

    protected void setC() {
        return;
    }

    protected String cetak() {
        return "Luas";
    }

    public  void logAktifitas(String userID, String aktifitas, String keterangan) {
        String query = "INSERT INTO log_aktifitas (id_user, aktifitas, keterangan) VALUES (?, ?, ?)";
        try {
            Connection koneksi = new KoneksiMysql().getKoneksi();
            PreparedStatement psmt = koneksi.prepareStatement(query);
            psmt.setString(1, userID);
            psmt.setString(2, aktifitas);
            psmt.setString(3, keterangan);
            psmt.executeUpdate();
            psmt.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }




    }
}
