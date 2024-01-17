package pbo.praktikum;

import java.sql.ResultSet;

interface ICRUD {
    ResultSet tampilData();
    String simpanData(String id, String nama, String alamat);
    String ubahData(String id, String nama, String alamat);
    String hapusData(String id);
    ResultSet cariData(String searchQuery);
}

public class CRUD extends BaseCRUD implements ICRUD  {

    CRUD() {
        try {
            koneksi = new KoneksiMysql().getKoneksi();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ResultSet tampilData() {
        query = "SELECT * FROM siswa";
        try {
            stat = koneksi.createStatement();
            hasil = stat.executeQuery(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return hasil;
    }

    public String simpanData(String id, String nama, String alamat) {
        query = "INSERT INTO siswa VALUES (?, ?, ?)";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, id);
            psmt.setString(2, nama);
            psmt.setString(3, alamat);
            psmt.executeUpdate();
            psmt.close();
            return "Data berhasil disimpan";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Data gagal disimpan";
        }
    }

    public String ubahData(String id, String nama, String alamat) {
        query = "UPDATE siswa SET nama=?, alamat=? WHERE id=?";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, nama);
            psmt.setString(2, alamat);
            psmt.setString(3, id);
            psmt.executeUpdate();
            psmt.close();
            return "Data berhasil diubah";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Data gagal diubah";
        }
    }

    public String hapusData(String id) {
        try {
            query = "DELETE FROM siswa WHERE id=?";
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1, id);
            psmt.executeUpdate();
            psmt.close();
            return "Data berhasil dihapus";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Data gagal dihapus";
        }
    }

    public ResultSet cariData(String searchQuery) {
        try {
            query = String.format(
                    "SELECT * FROM siswa WHERE id LIKE '%%%s%%' OR nama LIKE '%%%s%%'",
                    searchQuery,
                    searchQuery
            );
            stat = koneksi.createStatement();
            hasil = stat.executeQuery(query);
            return hasil;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
