package pbo.praktikum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiMysql {
    private Connection connection;
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String jdbc = "jdbc:mysql://localhost:3306/";
    private String database = "pbo_crud";
    private String url = jdbc + database;
    private String username = "root";
    private String password = "";

    public Connection getKoneksi() throws SQLException {
        if (connection == null) {
            try {
                Class.forName(driverName);
                System.out.println("Class Driver Ditemukan");
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Koneksi Database Sukses");
            } catch (SQLException se) {
                System.out.println("Koneksi Database Gagal :" + se);
                System.exit(0);
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada :" + cnfe);
                System.exit(0);
            }
        }
        return connection;
    }

}
