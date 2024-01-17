package pbo.praktikum;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

abstract class BaseCRUD {
    protected Connection koneksi;
    protected PreparedStatement psmt;
    protected Statement stat;
    protected ResultSet hasil;
    protected String query;
    public abstract ResultSet tampilData();
    public abstract String simpanData(String id, String nama, String alamat);
    public abstract String ubahData(String id, String nama, String alamat);
    public abstract String hapusData(String id);
    public abstract ResultSet cariData(String searchQuery);
}
