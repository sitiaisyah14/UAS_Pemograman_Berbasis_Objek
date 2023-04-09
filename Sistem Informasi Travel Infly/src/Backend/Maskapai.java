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
public class Maskapai {
    private int idmaskapai;
    private String namaPerusahaan;

    public Maskapai() {
    }

    public Maskapai(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }
    
    public static Maskapai getById(int id){
        Maskapai maskapai = new Maskapai();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM maskapai "
                                            +" WHERE id_maskapai = '"+ id+ "'");
        try {
            while(rs.next()){
                maskapai = new Maskapai();
                maskapai.setIdmaskapai(rs.getInt("id_maskapai"));
                maskapai.setNamaPerusahaan(rs.getString("nama_perusahaan"));
                
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return maskapai;
    }
    public static ArrayList<Maskapai> getAll(){
        ArrayList<Maskapai> ListMaskapai = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM maskapai");
        try {
            while(rs.next()){
                Maskapai maskapai = new Maskapai();
                maskapai.setIdmaskapai(rs.getInt("id_maskapai"));
                maskapai.setNamaPerusahaan(rs.getString("nama_perusahaan"));
                
                ListMaskapai.add(maskapai);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return ListMaskapai;
    }
    public static ArrayList<Maskapai> search(String keyword){
        ArrayList<Maskapai> ListMaskapai = new ArrayList();
        String sql = "SELECT * FROM maskapai WHERE " 
                + " nama_perusahaan LIKE '%" + keyword + "%' ";
              
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while(rs.next()){
                Maskapai maskapai = new Maskapai();
                maskapai.setIdmaskapai(rs.getInt("id_maskapai"));
                maskapai.setNamaPerusahaan(rs.getString("nama_perusahaan"));
                
                ListMaskapai.add(maskapai);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return ListMaskapai;
    }
    public void save(){
        if (getById(idmaskapai).getIdmaskapai()==0) {
            String SQL = "INSERT INTO maskapai (nama_perusahaan) VALUES ("
                    + " '" +this.namaPerusahaan + "'"
                    + " )";
            this.idmaskapai = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE maskapai SET "
                    + " nama_perusahaan = '" + this.namaPerusahaan+ "' "
                    + " WHERE id_maskapai = '" + this.idmaskapai + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    public void delete(){
        String SQL = "DELETE FROM maskapai WHERE id_maskapai = '" + this.idmaskapai + "' ";
        DBHelper.executeQuery(SQL);
    }
    
    public int getIdmaskapai() {
        return idmaskapai;
    }

    public void setIdmaskapai(int idmaskapai) {
        this.idmaskapai = idmaskapai;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }
    
    public String toString(){
        return namaPerusahaan;
    }
}
