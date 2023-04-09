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
public class Pesawat {
    private int idpesawat;
    private String namaPesawat;
    private Maskapai maskapai;

    public Pesawat() {
    }

    public Pesawat(String namaPesawat, Maskapai maskapai) {
        this.namaPesawat = namaPesawat;
        this.maskapai = maskapai;
    }
    
    public static ArrayList<Pesawat> getAll(){
        ArrayList<Pesawat> listPesawat = new ArrayList();
        String query = "SELECT pesawat.*,maskapai.nama_perusahaan"
                +" FROM pesawat"
                +" LEFT JOIN maskapai ON pesawat.id_maskapai = maskapai.id_maskapai ";
        
        ResultSet rs = DBHelper.selectQuery(query);
        
        try {
            while (rs.next()) {
                Maskapai maskapai = new Maskapai();
                maskapai.setIdmaskapai(rs.getInt("id_maskapai"));
                maskapai.setNamaPerusahaan(rs.getString("nama_perusahaan"));

                Pesawat pesawat = new Pesawat();
                pesawat.setIdpesawat(rs.getInt("id_pesawat"));
                pesawat.setNamaPesawat(rs.getString("nama_pesawat"));
                pesawat.setMaskapai(maskapai);

                listPesawat.add(pesawat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPesawat;
    }
    
    public static Pesawat getById(int id){
        Pesawat pesawat = new Pesawat();
        
        String query = "SELECT pesawat.*, maskapai.nama_perusahaan"
                        + " FROM pesawat"
                        + " LEFT JOIN maskapai ON pesawat.id_maskapai = maskapai.id_maskapai"
                        + " WHERE id_pesawat = "+id;
         ResultSet rs = DBHelper.selectQuery(query);
         try {
            while (rs.next()) {
                Maskapai maskapai = new Maskapai();
                maskapai.setIdmaskapai(rs.getInt("id_maskapai"));
                maskapai.setNamaPerusahaan(rs.getString("nama_perusahaan"));

                pesawat = new Pesawat();
                pesawat.setIdpesawat(rs.getInt("id_pesawat"));
                pesawat.setNamaPesawat(rs.getString("nama_pesawat"));
                pesawat.setMaskapai(maskapai);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pesawat;
    }
    
    public static ArrayList<Pesawat> search(String keyword){
        ArrayList<Pesawat> listPesawat = new ArrayList();
        String query = "SELECT pesawat.*,maskapai.nama_perusahaan"
                + " FROM pesawat"
                + " LEFT JOIN maskapai ON pesawat.id_maskapai = maskapai.id_maskapai "
                + " WHERE nama_pesawat LIKE '%" + keyword +"%'";

        ResultSet rs = DBHelper.selectQuery(query);
        try {
            while (rs.next()) {
                Maskapai maskapai = new Maskapai();
                maskapai.setIdmaskapai(rs.getInt("id_maskapai"));
                maskapai.setNamaPerusahaan(rs.getString("nama_perusahaan"));

                Pesawat pesawat = new Pesawat();
                pesawat.setIdpesawat(rs.getInt("id_pesawat"));
                pesawat.setNamaPesawat(rs.getString("nama_pesawat"));
                pesawat.setMaskapai(maskapai);

                listPesawat.add(pesawat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPesawat;
    }
    
    public void save(){
        if(this.idpesawat==0){
            String query = "INSERT INTO pesawat(nama_pesawat,id_maskapai) VALUES ("
                    + " '" + this.namaPesawat + "', "
                    + " '" + this.maskapai.getIdmaskapai()+ "'"
                    + " )";
            
            this.idpesawat = DBHelper.insertQueryGetId(query);
        } else {
            String SQL = " UPDATE pesawat SET "
                    + " nama_pesawat = '"+this.namaPesawat + "', "
                    + " id_maskapai = '"+this.maskapai.getIdmaskapai()+"' "
                    + " WHERE id_pesawat = '" + this.idpesawat+ "'";
            
            DBHelper.executeQuery(SQL);
        }
    }
    public void delete(){
        String query = "DELETE FROM pesawat WHERE id_pesawat = "+this.idpesawat;
        DBHelper.executeQuery(query);
                
    }
    public int getIdpesawat() {
        return idpesawat;
    }

    public void setIdpesawat(int idpesawat) {
        this.idpesawat = idpesawat;
    }

    public String getNamaPesawat() {
        return namaPesawat;
    }

    public void setNamaPesawat(String namaPesawat) {
        this.namaPesawat = namaPesawat;
    }

    public Maskapai getMaskapai() {
        return maskapai;
    }

    public void setMaskapai(Maskapai maskapai) {
        this.maskapai = maskapai;
    }
    
    public String toString(){
        return namaPesawat;
    }
}
