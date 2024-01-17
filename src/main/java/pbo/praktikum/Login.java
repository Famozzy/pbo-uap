package pbo.praktikum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

interface ILogin {
    String cekLogin(String userId, String password);
    void logout();
}

public class Login implements ILogin  {
    private final Connection koneksi;
    private PreparedStatement psmt;
    private String query;

    public Login() throws SQLException {
        try {
            koneksi = new KoneksiMysql().getKoneksi();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new SQLException("Koneksi database gagal");
        }
    }

    public String cekLogin(String userId, String password) {
        query = "SELECT * FROM user WHERE id_user=? AND password=md5(?)";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, userId);
            psmt.setString(2, password);
            ResultSet dataUser = psmt.executeQuery();
            if (dataUser.next()) {
                Session.setUserId(dataUser.getString("id_user"));
                Session.setNama(dataUser.getString("nama"));
                Session.setStatusLogin("AKTIF");

                query = "INSERT INTO log_login (id_user) VALUES (?)";
                try {
                    psmt = koneksi.prepareStatement(query);
                    psmt.setString(1, userId);
                    psmt.executeUpdate();
                    psmt.close();
                    return "OK";
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return "Gagal simpan log login";
                }
            }

            return "Gagal login";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Gagal login, Query error";
        }
    }

    public void logout() {
        query = "UPDATE log_login SET waktu_logout=CURRENT_TIMESTAMP() WHERE id_user=? ORDER BY id DESC LIMIT 1";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, Session.getUserId());
            psmt.executeUpdate();
            psmt.close();
            koneksi.close();

//            reset session
            Session.setUserId(null);
            Session.setNama(null);
            Session.setStatusLogin(null);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
