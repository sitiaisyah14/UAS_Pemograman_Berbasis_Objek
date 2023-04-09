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
public class Kota {
    private int idkota;
    private String namaKota;

    public Kota() {
    }

    public Kota(String namaKota) {
        this.namaKota = namaKota;
    }
    
    public static Kota getById(int id){
        Kota kota = new Kota();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM kota "
                                            +" WHERE id_kota = '"+ id+ "'");
        try {
            while(rs.next()){
                kota = new Kota();
                kota.setIdkota(rs.getInt("id_kota"));
                kota.setNamaKota(rs.getString("nama_kota"));
                
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return kota;
    }
    public static ArrayList<Kota> getAll(){
        ArrayList<Kota> ListKota = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM kota");
        try {
            while(rs.next()){
                Kota kota = new Kota();
                kota.setIdkota(rs.getInt("id_kota"));
                kota.setNamaKota(rs.getString("nama_kota"));
                
                ListKota.add(kota);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return ListKota;
    }
    
    public static ArrayList<Kota> search(String keyword){
        ArrayList<Kota> ListKota = new ArrayList();
        String sql = "SELECT * FROM kota WHERE " 
                + " nama_kota LIKE '%" + keyword + "%' ";
              
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while(rs.next()){
                Kota kota = new Kota();
                kota.setIdkota(rs.getInt("id_kota"));
                kota.setNamaKota(rs.getString("nama_kota"));
                
                ListKota.add(kota);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return ListKota;
    }
    public void save(){
        if (getById(idkota).getIdkota()==0) {
            String SQL = "INSERT INTO kota (nama_kota) VALUES ("
                    + " '" +this.namaKota + "'"
                    + " )";
            this.idkota = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE kota SET "
                    + " nama_kota = '" + this.namaKota+ "' "
                    + " WHERE id_kota = '" + this.idkota + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    public void delete(){
        String SQL = "DELETE FROM kota WHERE id_kota = '" + this.idkota + "' ";
        DBHelper.executeQuery(SQL);
    }

    public int getIdkota() {
        return idkota;
    }

    public void setIdkota(int idkota) {
        this.idkota = idkota;
    }

    public String getNamaKota() {
        return namaKota;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }
    public String toString(){
        return namaKota;
    }
    
}
