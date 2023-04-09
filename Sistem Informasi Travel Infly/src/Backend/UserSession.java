/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author WINDOWS 10
 */
public class UserSession {
    private static int idUser;
    private static String usernameUser;
    private static String passwordUser;
    private static String namaUser;
    private static String tglLahir;
    private static String jenisKelamin;
    private static String alamatUser;
    private static String telepon;
    private static String email;

    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        UserSession.idUser = idUser;
    }

    public static String getUsernameUser() {
        return usernameUser;
    }

    public static void setUsernameUser(String usernameUser) {
        UserSession.usernameUser = usernameUser;
    }

    public static String getPasswordUser() {
        return passwordUser;
    }

    public static void setPasswordUser(String passwordUser) {
        UserSession.passwordUser = passwordUser;
    }

    public static String getNamaUser() {
        return namaUser;
    }

    public static void setNamaUser(String namaUser) {
        UserSession.namaUser = namaUser;
    }

    public static String getTglLahir() {
        return tglLahir;
    }

    public static void setTglLahir(String tglLahir) {
        UserSession.tglLahir = tglLahir;
    }

    public static String getJenisKelamin() {
        return jenisKelamin;
    }

    public static void setJenisKelamin(String jenisKelamin) {
        UserSession.jenisKelamin = jenisKelamin;
    }

    public static String getAlamatUser() {
        return alamatUser;
    }

    public static void setAlamatUser(String alamatUser) {
        UserSession.alamatUser = alamatUser;
    }

    public static String getTelepon() {
        return telepon;
    }

    public static void setTelepon(String telepon) {
        UserSession.telepon = telepon;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UserSession.email = email;
    }
    
    
}
