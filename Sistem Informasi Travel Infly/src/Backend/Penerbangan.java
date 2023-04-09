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
public class Penerbangan {
    private int idpaket;
    private Kota asalkota;
    private Kota tujuankota;
    private Pesawat pesawat;
    private Maskapai maskapai;
    private int hargaTiket;
    private String jamBerangkat;
    private String jamKedatangan;
    private String tanggalBerangkat;

    public Penerbangan() {
    }

    public Penerbangan(Kota asalkota, Kota tujuankota, Pesawat pesawat, Maskapai maskapai, int hargaTiket, String jamBerangkat, String jamKedatangan, String tanggalBerangkat) {
        this.asalkota = asalkota;
        this.tujuankota = tujuankota;
        this.pesawat = pesawat;
        this.maskapai = maskapai;
        this.hargaTiket = hargaTiket;
        this.jamBerangkat = jamBerangkat;
        this.jamKedatangan = jamKedatangan;
        this.tanggalBerangkat = tanggalBerangkat;
    }


    public static ArrayList<Penerbangan> getAll(){
        ArrayList<Penerbangan> listPenerbangan = new ArrayList();
        String query = "SELECT penerbangan.*, ka.id_kota as idkotaasal,kt.id_kota as idkotatujuan,"
                + "ka.nama_kota as kota_asal,kt.nama_kota as kota_tujuan,pesawat.nama_pesawat,maskapai.nama_perusahaan,pesawat.id_pesawat,maskapai.id_maskapai"
                        + " FROM penerbangan"
                        + " LEFT JOIN kota ka ON penerbangan.asal_kota = ka.id_kota"
                        + " LEFT JOIN kota kt ON penerbangan.tujuan_kota = kt.id_kota"
                        + " LEFT JOIN pesawat ON penerbangan.id_pesawat = pesawat.id_pesawat"
                        + " LEFT JOIN maskapai ON pesawat.id_maskapai = maskapai.id_maskapai";
        
         ResultSet rs = DBHelper.selectQuery(query);
         
         try {
             while(rs.next()){
                 Kota kota = new Kota();
                 kota.setIdkota(rs.getInt("idkotaasal"));
                 kota.setNamaKota(rs.getString("kota_asal"));
                 
                 Kota kota2 = new Kota();
                 kota2.setIdkota(rs.getInt("idkotatujuan"));
                 kota2.setNamaKota(rs.getString("kota_tujuan"));
                 
                 Pesawat psw = new Pesawat();
                 psw.setIdpesawat(rs.getInt("id_pesawat"));
                 psw.setNamaPesawat(rs.getString("nama_pesawat"));
                 
                 Maskapai maskapai = new Maskapai();
                 maskapai.setIdmaskapai(rs.getInt("id_maskapai"));
                 maskapai.setNamaPerusahaan(rs.getString("nama_perusahaan"));
                 
                 Penerbangan pb = new Penerbangan();
                 pb.setIdpaket(rs.getInt("id_paket"));
                 pb.setAsalkota(kota);
                 pb.setTujuankota(kota2);
                 pb.setPesawat(psw);
                 pb.setMaskapai(maskapai);
                 pb.setHargaTiket(rs.getInt("harga_tiket"));
                 pb.setJamBerangkat(rs.getString("jam_berangkat"));
                 pb.setJamKedatangan(rs.getString("jam_kedatangan"));
                 pb.setTanggalBerangkat(rs.getString("tanggal_berangkat"));
                 
                 listPenerbangan.add(pb);
             }
         } catch (Exception e){
             e.printStackTrace();
         }
         return listPenerbangan;
    }
    
    public static Penerbangan getById(int id){
        Penerbangan pb = new Penerbangan();
                String query = "SELECT penerbangan.*, ka.id_kota as idkotaasal,kt.id_kota as idkotatujuan,"
                + "ka.nama_kota as kota_asal,kt.nama_kota as kota_tujuan,pesawat.nama_pesawat,maskapai.nama_perusahaan,pesawat.id_pesawat,maskapai.id_maskapai"
                        + " FROM penerbangan"
                        + " LEFT JOIN kota ka ON penerbangan.asal_kota = ka.id_kota"
                        + " LEFT JOIN kota kt ON penerbangan.tujuan_kota = kt.id_kota"
                        + " LEFT JOIN pesawat ON penerbangan.id_pesawat = pesawat.id_pesawat"
                        + " LEFT JOIN maskapai ON pesawat.id_maskapai = maskapai.id_maskapai"
                        + " WHERE id_paket = "+id;
        
        ResultSet rs = DBHelper.selectQuery(query);
        try {
            while(rs.next()){
                 Kota kota = new Kota();
                 kota.setIdkota(rs.getInt("idkotaasal"));
                 kota.setNamaKota(rs.getString("kota_asal"));
                 
                 Kota kota2 = new Kota();
                 kota2.setIdkota(rs.getInt("idkotatujuan"));
                 kota2.setNamaKota(rs.getString("kota_tujuan"));
                 
                 Pesawat psw = new Pesawat();
                 psw.setIdpesawat(rs.getInt("id_pesawat"));
                 psw.setNamaPesawat(rs.getString("nama_pesawat"));
                 
                 Maskapai maskapai = new Maskapai();
                 maskapai.setIdmaskapai(rs.getInt("id_maskapai"));
                 maskapai.setNamaPerusahaan(rs.getString("nama_perusahaan"));
                 
                 pb = new Penerbangan();
                 pb.setIdpaket(rs.getInt("id_paket"));
                 pb.setAsalkota(kota);
                 pb.setTujuankota(kota2);
                 pb.setPesawat(psw);
                 pb.setMaskapai(maskapai);
                 pb.setHargaTiket(rs.getInt("harga_tiket"));
                 pb.setJamBerangkat(rs.getString("jam_berangkat"));
                 pb.setJamKedatangan(rs.getString("jam_kedatangan"));
                 pb.setTanggalBerangkat(rs.getString("tanggal_berangkat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pb;
    }
    public static ArrayList<Penerbangan> search(String keyword){
        ArrayList<Penerbangan> listPenerbangan = new ArrayList();
        String query = "SELECT penerbangan.*, ka.nama_kota as kota_asal,kt.nama_kota as kota_tujuan,pesawat.nama_pesawat,maskapai.nama_perusahaan"
                        + " FROM penerbangan"
                        + " LEFT JOIN kota ka ON penerbangan.asal_kota = ka.id_kota"
                        + " LEFT JOIN kota kt ON penerbangan.tujuan_kota = kt.id_kota"
                        + " LEFT JOIN pesawat ON penerbangan.id_pesawat = pesawat.id_pesawat"
                        + " LEFT JOIN maskapai ON pesawat.id_maskapai = maskapai.id_maskapai"
                        + " WHERE asal_kota = (SELECT id_kota FROM kota WHERE nama_kota LIKE '%" + keyword + "%')"
                        + " OR tujuan_kota = (SELECT id_kota FROM kota WHERE nama_kota LIKE '%" + keyword + "%')"
                        + " OR penerbangan.id_pesawat = (SELECT id_pesawat FROM pesawat WHERE nama_pesawat LIKE '%" + keyword + "%')"
                        + " OR maskapai.id_maskapai = (SELECT id_maskapai FROM maskapai WHERE nama_perusahaan LIKE '%"+ keyword +"%')"
                        + " OR tanggal_berangkat LIKE '%" + keyword + "%'";
        
        ResultSet rs = DBHelper.selectQuery(query);
        
        try {
            while(rs.next()){
                Kota kota = new Kota();
                 kota.setNamaKota(rs.getString("kota_asal"));
                 
                 Kota kota2 = new Kota();
                 kota2.setNamaKota(rs.getString("kota_tujuan"));
                 
                 Pesawat psw = new Pesawat();
                 psw.setNamaPesawat(rs.getString("nama_pesawat"));
                 
                 Maskapai maskapai = new Maskapai();
                 maskapai.setNamaPerusahaan(rs.getString("nama_perusahaan"));
                 
                 Penerbangan pb = new Penerbangan();
                 pb.setIdpaket(rs.getInt("id_paket"));
                 pb.setAsalkota(kota);
                 pb.setTujuankota(kota2);
                 pb.setPesawat(psw);
                 pb.setMaskapai(maskapai);
                 pb.setHargaTiket(rs.getInt("harga_tiket"));
                 pb.setJamBerangkat(rs.getString("jam_berangkat"));
                 pb.setJamKedatangan(rs.getString("jam_kedatangan"));
                 pb.setTanggalBerangkat(rs.getString("tanggal_berangkat"));
                 
                 listPenerbangan.add(pb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPenerbangan;
    }
    public void save(){
       if(this.idpaket == 0) {
           String query = "INSERT INTO penerbangan (asal_kota,tujuan_kota"
                   + ",id_pesawat,harga_tiket,jam_berangkat,jam_kedatangan,tanggal_berangkat)VALUES ("
                   + " " +  this.asalkota.getIdkota()+ ", "
                   + " '" + this.tujuankota.getIdkota()+ "', "
                   + " '" + this.pesawat.getIdpesawat() + "', "
                   + " '" + this.hargaTiket + "', "
                   + " '" + this.jamBerangkat + "', "
                   + " '" + this.jamKedatangan + "', "
                   + " '" + this.tanggalBerangkat + "')";
           System.out.println(this.pesawat.getIdpesawat());
           System.out.println(query);
                this.idpaket = DBHelper.insertQueryGetId(query);
       } else {
           String SQL = "UPDATE penerbangan SET "
                   + " asal_kota = " +this.asalkota.getIdkota()+ ", "
                   + " tujuan_kota ='" +this.tujuankota.getIdkota()+ "', "
                   + " id_pesawat = '" +this.pesawat.getIdpesawat()+ "', "
                   + " harga_tiket = '"+ this.hargaTiket+ "', "
                   + " jam_berangkat = '"+this.jamBerangkat + "', "
                   + " jam_kedatangan = '"+this.jamKedatangan + "', "
                   + " tanggal_berangkat ='"+this.tanggalBerangkat+ "'"
                   + " WHERE id_paket = '" +this.idpaket + "'";
           System.out.println(SQL);
           DBHelper.executeQuery(SQL);
       }
    }
    public void delete(){
        String query = "DELETE FROM penerbangan WHERE id_paket = " + this.idpaket;
        DBHelper.executeQuery(query);
    }
    
    public int getIdpaket() {
        return idpaket;
    }

    public void setIdpaket(int idpaket) {
        this.idpaket = idpaket;
    }

    public Kota getAsalkota() {
        return asalkota;
    }

    public void setAsalkota(Kota asalkota) {
        this.asalkota = asalkota;
    }

    public Kota getTujuankota() {
        return tujuankota;
    }

    public void setTujuankota(Kota tujuankota) {
        this.tujuankota = tujuankota;
    }

    public Pesawat getPesawat() {
        return pesawat;
    }

    public void setPesawat(Pesawat pesawat) {
        this.pesawat = pesawat;
    }

    public String getJamBerangkat() {
        return jamBerangkat;
    }

    public void setJamBerangkat(String jamBerangkat) {
        this.jamBerangkat = jamBerangkat;
    }

    public String getJamKedatangan() {
        return jamKedatangan;
    }

    public void setJamKedatangan(String jamKedatangan) {
        this.jamKedatangan = jamKedatangan;
    }

    public String getTanggalBerangkat() {
        return tanggalBerangkat;
    }

    public void setTanggalBerangkat(String tanggalBerangkat) {
        this.tanggalBerangkat = tanggalBerangkat;
    }

    public int getHargaTiket() {
        return hargaTiket;
    }

    public void setHargaTiket(int hargaTiket) {
        this.hargaTiket = hargaTiket;
    }

    public Maskapai getMaskapai() {
        return maskapai;
    }

    public void setMaskapai(Maskapai maskapai) {
        this.maskapai = maskapai;
    }
    public String toString(){
        return tanggalBerangkat;
    }
}
