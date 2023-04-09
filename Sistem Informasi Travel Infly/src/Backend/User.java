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
import java.util.ArrayList;
import java.sql.*;
public class User {
    private int iduser;
    private String usernameUser;
    private String passwordUser;
    private String namaUser;
    private String tglLahir;
    private String jenisKelamin;
    private String alamatUser;
    private String no_telepon;
    private String emailUser;

    public User() {
    }

    public User(String usernameUser, String passwordUser, String namaUser, String tglLahir, String jenisKelamin, String alamatUser, String no_telepon, String emailUser) {
        this.usernameUser = usernameUser;
        this.passwordUser = passwordUser;
        this.namaUser = namaUser;
        this.tglLahir = tglLahir;
        this.jenisKelamin = jenisKelamin;
        this.alamatUser = alamatUser;
        this.no_telepon = no_telepon;
        this.emailUser = emailUser;
    }
    public static User getById(int id){
        User user = new User();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM user "
                                            +" WHERE id_user = '"+ id+ "'");
        try {
            while(rs.next()){
                user = new User();
                user.setIduser(rs.getInt("id_user"));
                user.setUsernameUser(rs.getString("username_user"));
                user.setPasswordUser(rs.getString("password_user"));
                user.setNamaUser(rs.getString("nama_user"));
                user.setTglLahir(rs.getString("tgllahir_user"));
                user.setJenisKelamin(rs.getString("jenisKelamin"));
                user.setAlamatUser(rs.getString("alamat_user"));
                user.setNo_telepon(rs.getString("no_telepon"));
                user.setEmailUser(rs.getString("email_user"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
    
    public static ArrayList<User> getAll(){
        ArrayList<User> ListUser = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM user");
        try {
            while(rs.next()){
                User user = new User();
                user.setIduser(rs.getInt("id_user"));
                user.setUsernameUser(rs.getString("username_user"));
                user.setPasswordUser(rs.getString("password_user"));
                user.setNamaUser(rs.getString("nama_user"));
                user.setTglLahir(rs.getString("tgllahir_user"));
                user.setJenisKelamin(rs.getString("jenisKelamin"));
                user.setAlamatUser(rs.getString("alamat_user"));
                user.setNo_telepon(rs.getString("no_telepon"));
                user.setEmailUser(rs.getString("email_user"));
                
                ListUser.add(user);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return ListUser;
    }
    
     public static ArrayList<User> search(String keyword){
        ArrayList<User> ListUser = new ArrayList();
        String sql = "SELECT * FROM user WHERE " 
                + " username_user LIKE '%" + keyword + "%' "
                + " OR password_user LIKE '%" + keyword + "%'"
                + " OR nama_user LIKE '%" + keyword + "%'"
                + " OR tgllahir_user LIKE '%" + keyword + "%'"
                + " OR jenisKelamin LIKE '%" + keyword + "%'"
                + " OR alamat_user LIKE '%" + keyword + "%'"
                + " OR no_telepon LIKE '%" + keyword + "%'"
                + " OR email_user LIKE '%" + keyword + "%'";
              
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while(rs.next()){
                User user = new User();
                user.setIduser(rs.getInt("id_user"));
                user.setUsernameUser(rs.getString("username_user"));
                user.setPasswordUser(rs.getString("password_user"));
                user.setNamaUser(rs.getString("nama_user"));
                user.setTglLahir(rs.getString("tgllahir_user"));
                user.setJenisKelamin(rs.getString("jenisKelamin"));
                user.setAlamatUser(rs.getString("alamat_user"));
                user.setNo_telepon(rs.getString("no_telepon"));
                user.setEmailUser(rs.getString("email_user"));
                
                ListUser.add(user);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return ListUser;
    }
    public void save(){
        if (getById(iduser).getIduser()==0) {
            String SQL = "INSERT INTO user (username_user,password_user,nama_user,"
                    + "tgllahir_user,jenisKelamin,alamat_user,no_telepon,email_user) VALUES ("
                    + " '" +this.usernameUser + "', "
                    + " '"+ this.passwordUser+"', "
                    + " '"+ this.namaUser+"', "
                    + " '"+ this.tglLahir+"', "
                    + " '"+ this.jenisKelamin+"', "
                    + " '"+ this.alamatUser+"', "
                    + " '"+ this.no_telepon+"', "
                    + " '"+ this.emailUser+"'"
                    + " )";
            this.iduser = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE user SET "
                    + " username_user = '" + this.usernameUser+ "', "
                    + " password_user = '" + this.passwordUser + "', "
                    + " nama_user = '" + this.namaUser + "', "
                    + " tgllahir_user = '" + this.tglLahir + "', "
                    + " jenisKelamin = '" + this.jenisKelamin + "', "
                    + " alamat_user = '" + this.alamatUser + "', "
                    + " no_telepon = '" + this.no_telepon + "', "
                    + " email_user = '" + this.emailUser + "' "
                    + " WHERE id_user = '" + this.iduser + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    public void delete(){
        String SQL = "DELETE FROM user WHERE id_user = '" + this.iduser + "' ";
        System.out.println(SQL);
        DBHelper.executeQuery(SQL);
    }
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getUsernameUser() {
        return usernameUser;
    }

    public void setUsernameUser(String usernameUser) {
        this.usernameUser = usernameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamatUser() {
        return alamatUser;
    }

    public void setAlamatUser(String alamatUser) {
        this.alamatUser = alamatUser;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
    
    public String toString(){
        return namaUser;
    }
}
