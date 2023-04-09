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
public class Admin {
    private int idadmin;
    private String usernameAdmin;
    private String passwordAdmin;
    private String namaAdmin;
    private String tglLahir;
    private String jenisKelamin;
    private String alamatAdmin;
    private String no_telepon;
    private String emailAdmin;

    public Admin() {
    }

    public Admin(String usernameAdmin, String passwordAdmin, String namaAdmin, String tglLahir, String jenisKelamin, String alamatAdmin, String no_telepon, String emailAdmin) {
        this.usernameAdmin = usernameAdmin;
        this.passwordAdmin = passwordAdmin;
        this.namaAdmin = namaAdmin;
        this.tglLahir = tglLahir;
        this.jenisKelamin = jenisKelamin;
        this.alamatAdmin = alamatAdmin;
        this.no_telepon = no_telepon;
        this.emailAdmin = emailAdmin;
    }

    
    public static Admin getById(int id){
        Admin admin = new Admin();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM admin "
                                            +" WHERE id_admin = '"+ id+ "'");
        try {
            while(rs.next()){
                admin = new Admin();
                admin.setIdadmin(rs.getInt("id_admin"));
                admin.setUsernameAdmin(rs.getString("username_admin"));
                admin.setPasswordAdmin(rs.getString("password_admin"));
                admin.setNamaAdmin(rs.getString("nama_admin"));
                admin.setTglLahir(rs.getString("tgllahir_admin"));
                admin.setJenisKelamin(rs.getString("jenis_kelamin"));
                admin.setAlamatAdmin(rs.getString("alamat_admin"));
                admin.setNo_telepon(rs.getString("no_telepon"));
                admin.setEmailAdmin(rs.getString("email_admin"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return admin;
    }
    public static ArrayList<Admin> getAll(){
        ArrayList<Admin> ListAdmin = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM admin");
        try {
            while(rs.next()){
                Admin admin = new Admin();
                admin.setIdadmin(rs.getInt("id_admin"));
                admin.setUsernameAdmin(rs.getString("username_admin"));
                admin.setPasswordAdmin(rs.getString("password_admin"));
                admin.setNamaAdmin(rs.getString("nama_admin"));
                admin.setTglLahir(rs.getString("tgllahir_admin"));
                admin.setJenisKelamin(rs.getString("jenis_kelamin"));
                admin.setAlamatAdmin(rs.getString("alamat_admin"));
                admin.setNo_telepon(rs.getString("no_telepon"));
                admin.setEmailAdmin(rs.getString("email_admin"));
                
                ListAdmin.add(admin);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return ListAdmin;
    }
    public static ArrayList<Admin> search(String keyword){
        ArrayList<Admin> ListAdmin = new ArrayList();
        String sql = "SELECT * FROM admin WHERE " 
                + " username_admin LIKE '%" + keyword + "%' "
                + " OR password_admin LIKE '%" + keyword + "%'"
                + " OR nama_admin LIKE '%" + keyword + "%'"
                + " OR tgllahir_admin LIKE '%" + keyword + "%'"
                + " OR jenis_kelamin LIKE '%" + keyword + "%'"
                + " OR alamat_admin LIKE '%" + keyword + "%'"
                + " OR no_telepon LIKE '%" + keyword + "%'"
                + " OR email_admin LIKE '%" + keyword + "%'";
              
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while(rs.next()){
                Admin admin = new Admin();
                admin.setIdadmin(rs.getInt("id_admin"));
                admin.setUsernameAdmin(rs.getString("username_admin"));
                admin.setPasswordAdmin(rs.getString("password_admin"));
                admin.setNamaAdmin(rs.getString("nama_admin"));
                admin.setTglLahir(rs.getString("tgllahir_admin"));
                admin.setJenisKelamin(rs.getString("jenis_kelamin"));
                admin.setAlamatAdmin(rs.getString("alamat_admin"));
                admin.setNo_telepon(rs.getString("no_telepon"));
                admin.setEmailAdmin(rs.getString("email_admin"));
                
                ListAdmin.add(admin);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return ListAdmin;
    }
    public void save(){
        if (getById(idadmin).getIdadmin()==0) {
            String SQL = "INSERT INTO admin (username_admin,password_admin,nama_admin,"
                    + "tgllahir_admin,jenis_kelamin,alamat_admin,no_telepon,email_admin) VALUES ("
                    + " '" +this.usernameAdmin + "', "
                    + " '"+ this.passwordAdmin+"', "
                    + " '"+ this.namaAdmin+"', "
                    + " '"+ this.tglLahir+"', "
                    + " '"+ this.jenisKelamin+"', "
                    + " '"+ this.alamatAdmin+"', "
                    + " '"+ this.no_telepon+"', "
                    + " '"+ this.emailAdmin+"'"
                    + " )";
            this.idadmin = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE admin SET "
                    + " username_admin = '" + this.usernameAdmin+ "', "
                    + " password_admin = '" + this.passwordAdmin + "', "
                    + " nama_admin = '" + this.namaAdmin + "', "
                    + " tgllahir_admin = '" + this.tglLahir + "', "
                    + " jenis_kelamin = '" + this.jenisKelamin + "', "
                    + " alamat_admin = '" + this.alamatAdmin + "', "
                    + " no_telepon = '" + this.no_telepon + "', "
                    + " email_admin = '" + this.emailAdmin + "' "
                    + " WHERE id_admin = '" + this.idadmin + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    public void delete(){
        String SQL = "DELETE FROM admin WHERE id_admin = '" + this.idadmin + "' ";
        DBHelper.executeQuery(SQL);
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public String getUsernameAdmin() {
        return usernameAdmin;
    }

    public void setUsernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    public String getNamaAdmin() {
        return namaAdmin;
    }

    public void setNamaAdmin(String namaAdmin) {
        this.namaAdmin = namaAdmin;
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
    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public String getAlamatAdmin() {
        return alamatAdmin;
    }

    public void setAlamatAdmin(String alamatAdmin) {
        this.alamatAdmin = alamatAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }
}
