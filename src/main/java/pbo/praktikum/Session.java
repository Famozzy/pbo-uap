package pbo.praktikum;

public class Session {
    private static String userId, nama, statusLogin;

    public static String getUserId() {
        return userId;
    }
    public static void setUserId(String userId) {
        Session.userId = userId;
    }

    public static String getNama() {
        return nama;
    }
    public static void setNama(String nama) {
        Session.nama = nama;
    }

    public static String getStatusLogin() {
        return statusLogin;
    }
    public static void setStatusLogin(String statusLogin) {
        Session.statusLogin = statusLogin;
    }

}
