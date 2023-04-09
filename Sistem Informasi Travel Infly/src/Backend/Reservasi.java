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
import Frontend.Tanggal;
import java.util.ArrayList;
import java.sql.*;
public class Reservasi {
    private int idreservasi;
    private User user;
    private Penerbangan penerbangan;
    private Pesawat pesawat;
    private Kota asalkota;
    private Kota tujuankota;
    private String kelas;
    private String hargaTiket;
    private String namaPemesan;
    private String tglBayar;
    private String status;

    public Reservasi() {
    }

    public Reservasi(User user, Penerbangan penerbangan, Pesawat pesawat, Kota asalkota, Kota tujuankota, String kelas, String hargaTiket, String namaPemesan, String tglBayar, String status) {
        this.user = user;
        this.penerbangan = penerbangan;
        this.pesawat = pesawat;
        this.asalkota = asalkota;
        this.tujuankota = tujuankota;
        this.kelas = kelas;
        this.hargaTiket = hargaTiket;
        this.namaPemesan = namaPemesan;
        this.tglBayar = tglBayar;
        this.status = status;
    }

    
    public static ArrayList<Reservasi> getAll(){
        ArrayList<Reservasi> listReservasi = new ArrayList();
        String query = "SELECT reservasi.*,user.nama_user,penerbangan.id_pesawat,pesawat.nama_pesawat,penerbangan.harga_tiket,penerbangan.tanggal_berangkat,"
                + " penerbangan.asal_kota,penerbangan.tujuan_kota,ka.nama_kota as kota_asal, kt.nama_kota as kota_tujuan"
                + " FROM reservasi"
                + " LEFT JOIN user ON reservasi.id_user = user.id_user"
                + " LEFT JOIN penerbangan ON reservasi.id_paket = penerbangan.id_paket"
                + " LEFT JOIN pesawat ON penerbangan.id_pesawat = pesawat.id_pesawat"
                + " LEFT JOIN kota ka  ON penerbangan.asal_kota = ka.id_kota"
                + " LEFT JOIN kota kt ON penerbangan.tujuan_kota = kt.id_kota";
        ResultSet rs = DBHelper.selectQuery(query);
        
        try {
            while(rs.next()){
                User user = new User();
                user.setIduser(rs.getInt("id_user"));
                user.setNamaUser(rs.getString("nama_user"));
                
                Kota ka = new Kota();
                ka.setNamaKota(rs.getString("kota_asal"));
                
                Kota kt = new Kota();
                kt.setNamaKota(rs.getString("kota_tujuan"));
                
                Penerbangan pb = new Penerbangan();
                pb.setIdpaket(rs.getInt("id_pesawat"));
                pb.setTanggalBerangkat(rs.getString("tanggal_berangkat"));
                
                Pesawat psw = new Pesawat();
                psw.setNamaPesawat(rs.getString("nama_pesawat"));
                
                Reservasi reservasi = new Reservasi();
                reservasi.setIdreservasi(rs.getInt("id_reservasi"));
                reservasi.setUser(user);
                reservasi.setPenerbangan(pb);
                reservasi.setPesawat(psw);
                reservasi.setAsalkota(ka);
                reservasi.setTujuankota(kt);
                reservasi.setKelas(rs.getString("kelas"));
                reservasi.setHargaTiket(rs.getString("harga_tiket"));
                reservasi.setNamaPemesan(rs.getString("nama_pemesan"));
                reservasi.setTglBayar(rs.getString("tanggal_bayar"));
                reservasi.setStatus(rs.getString("status"));
                
                listReservasi.add(reservasi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listReservasi;
    }
    
    public static Reservasi getById(int id){
        Reservasi reservasi = new Reservasi();
        String query = "SELECT reservasi.*, user.nama_user,penerbangan.id_pesawat,pesawat.nama_pesawat,penerbangan.harga_tiket,penerbangan.tanggal_berangkat,"
                + " penerbangan.asal_kota,penerbangan.tujuan_kota,ka.nama_kota as kota_asal, kt.nama_kota as kota_tujuan"
                + " FROM reservasi"
                + " LEFT JOIN user ON reservasi.id_user = user.id_user"
                + " LEFT JOIN penerbangan ON reservasi.id_paket = penerbangan.id_paket"
                + " LEFT JOIN pesawat ON penerbangan.id_pesawat = pesawat.id_pesawat"
                + " LEFT JOIN kota ka  ON penerbangan.asal_kota = ka.id_kota"
                + " LEFT JOIN kota kt ON penerbangan.tujuan_kota = kt.id_kota"
                + " WHERE id_reservasi = "+id;
        
        ResultSet rs = DBHelper.selectQuery(query);
        try {
            while(rs.next()){
                User user = new User();
                user.setIduser(rs.getInt("id_user"));
                user.setNamaUser(rs.getString("nama_user"));
                
                Kota ka = new Kota();
                ka.setNamaKota(rs.getString("kota_asal"));
                
                Kota kt = new Kota();
                kt.setNamaKota(rs.getString("kota_tujuan"));
                
                Penerbangan pb = new Penerbangan();
                pb.setIdpaket(rs.getInt("id_pesawat"));
                pb.setTanggalBerangkat(rs.getString("tanggal_berangkat"));
                
                Pesawat psw = new Pesawat();
                psw.setNamaPesawat(rs.getString("nama_pesawat"));
                
                reservasi = new Reservasi();
                reservasi.setIdreservasi(rs.getInt("id_reservasi"));
                reservasi.setUser(user);
                reservasi.setPenerbangan(pb);
                reservasi.setPesawat(psw);
                reservasi.setAsalkota(ka);
                reservasi.setTujuankota(kt);
                reservasi.setKelas(rs.getString("kelas"));
                reservasi.setHargaTiket(rs.getString("harga_tiket"));
                reservasi.setNamaPemesan(rs.getString("nama_pemesan"));
                reservasi.setTglBayar(rs.getString("tanggal_bayar"));
                reservasi.setStatus(rs.getString("status"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservasi;
    }
    public static ArrayList<Reservasi> search(String keyword){
        ArrayList<Reservasi> listReservasi = new ArrayList();
        String query = "SELECT reservasi.*, user.id_user,penerbangan.id_pesawat,pesawat.nama_pesawat,penerbangan.harga_tiket,penerbangan.tanggal_berangkat,"
                        + " penerbangan.asal_kota,penerbangan.tujuan_kota,ka.nama_kota as kota_asal, kt.nama_kota as kota_tujuan"
                        + " FROM reservasi"
                        + " LEFT JOIN user ON reservasi.id_user = user.id_user"
                        + " LEFT JOIN penerbangan ON reservasi.id_paket = penerbangan.id_paket"
                        + " LEFT JOIN pesawat ON penerbangan.id_pesawat = pesawat.id_pesawat"
                        + " LEFT JOIN kota ka  ON penerbangan.asal_kota = ka.id_kota"
                        + " LEFT JOIN kota kt ON penerbangan.tujuan_kota = kt.id_kota"
                        + " WHERE penerbangan.id_pesawat = (SELECT id_pesawat FROM pesawat WHERE nama_pesawat LIKE '%" + keyword + "%')"
                        + " OR kelas LIKE '%" + keyword + "%'"
                        + " OR nama_pemesan LIKE '%" + keyword + "%'"
                        + " OR penerbangan.id_paket = (SELECT id_paket FROM penerbangan WHERE tanggal_berangkat LIKE '%"+ keyword +"%')"
                        + " OR tanggal_bayar LIKE '%" + keyword + "%'"
                        + " OR status LIKE '%" + keyword + "%'"
                        + " OR penerbangan.asal_kota = (SELECT id_kota FROM kota WHERE nama_kota LIKE '%"+ keyword +"%')"
                        + " OR penerbangan.tujuan_kota = (SELECT id_kota FROM kota WHERE nama_kota LIKE '%"+ keyword +"%')";
        
        ResultSet rs = DBHelper.selectQuery(query);
        
        try {
            while(rs.next()){
                User user = new User();
                user.setIduser(rs.getInt("id_user"));
                
                Kota ka = new Kota();
                ka.setNamaKota(rs.getString("kota_asal"));
                
                Kota kt = new Kota();
                kt.setNamaKota(rs.getString("kota_tujuan"));
                
                Penerbangan pb = new Penerbangan();
                pb.setIdpaket(rs.getInt("id_pesawat"));
                pb.setTanggalBerangkat(rs.getString("tanggal_berangkat"));
                
                Pesawat psw = new Pesawat();
                psw.setNamaPesawat(rs.getString("nama_pesawat"));
                
                Reservasi reservasi = new Reservasi();
                reservasi.setIdreservasi(rs.getInt("id_reservasi"));
                reservasi.setUser(user);
                reservasi.setPenerbangan(pb);
                reservasi.setPesawat(psw);
                reservasi.setAsalkota(ka);
                reservasi.setTujuankota(kt);
                reservasi.setKelas(rs.getString("kelas"));
                reservasi.setHargaTiket(rs.getString("harga_tiket"));
                reservasi.setNamaPemesan(rs.getString("nama_pemesan"));
                reservasi.setTglBayar(rs.getString("tanggal_bayar"));
                reservasi.setStatus(rs.getString("status"));
                 
                listReservasi.add(reservasi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listReservasi;
    }
    public void save(){
       if(this.idreservasi == 0) {
           String query = "INSERT INTO reservasi (id_user,id_paket,kelas,harga_tiket,nama_pemesan,"
                   + "tanggal_berangkat,tanggal_bayar,status ) VALUES ("
                   + " " +  this.user.getIduser()+ ", "
                   + " '" + this.penerbangan.getIdpaket()+ "', "
                   + " '" + this.kelas + "', "
                   + " '" + this.hargaTiket+ "', "
                   + " '" + this.namaPemesan + "', "
                   + " '" + this.penerbangan.getTanggalBerangkat() + "', "
                   + "null," 
                   + " '" + this.status + "')";
           System.out.println(query);
                this.idreservasi = DBHelper.insertQueryGetId(query);
                
       } else {
           String SQL = "UPDATE reservasi SET "
                   + " id_user = " +this.user.getIduser()+", "
                   + " id_paket = '"+this.penerbangan.getIdpaket()+"', "
                   + " kelas = '"+this.kelas+ "', "
                   + " harga_tiket = '"+ this.hargaTiket+ "', "
                   + " nama_pemesan = '"+this.namaPemesan + "', "
                   + " tanggal_berangkat = '"+this.penerbangan.getTanggalBerangkat()+ "', "
                   + " tanggal_bayar ='"+this.tglBayar +"', "
                   + " status ='"+this.status+"'"
                   + " WHERE id_reservasi = '" +this.idreservasi + "'";        
           DBHelper.executeQuery(SQL);
       }
    }
    public void saveAdmin(){
       if(this.idreservasi == 0) {
           String query = "INSERT INTO reservasi (id_user,id_paket,kelas,harga_tiket,nama_pemesan,"
                   + "tanggal_berangkat,tanggal_bayar,status ) VALUES ("
                   + " " +  this.user.getIduser()+ ", "
                   + " '" + this.penerbangan.getIdpaket()+ "', "
                   + " '" + this.kelas + "', "
                   + " '" + this.hargaTiket+ "', "
                   + " '" + this.namaPemesan + "', "
                   + " '" + this.penerbangan.getTanggalBerangkat() + "', "
                   + " '" + this.tglBayar+getTglBayar() + "', "
                   + " '" + this.status + "')";
           System.out.println(query);
                this.idreservasi = DBHelper.insertQueryGetId(query);
                
       } else {
           String SQL = "UPDATE reservasi SET "
                   + " id_user = " +this.user.getIduser()+", "
                   + " id_paket = '"+this.penerbangan.getIdpaket()+"', "
                   + " kelas = '"+this.kelas+ "', "
                   + " harga_tiket = '"+ this.hargaTiket+ "', "
                   + " nama_pemesan = '"+this.namaPemesan + "', "
                   + " tanggal_berangkat = '"+this.penerbangan.getTanggalBerangkat()+ "', "
                   + " tanggal_bayar ='"+this.tglBayar +"', "
                   + " status ='"+this.status+"'"
                   + " WHERE id_reservasi = '" +this.idreservasi + "'";   
           System.out.println(SQL);
           DBHelper.executeQuery(SQL);
       }
    }
    
    public void bayar(){
       String SQL = "UPDATE reservasi SET tanggal_bayar = '"+Tanggal.getTanggalSekarang()+"', status='"+this.status+"' WHERE id_reservasi = "+this.idreservasi;
       System.out.println(SQL);
       DBHelper.executeQuery(SQL);
    }
    public void batalBayar(){
        String SQL = "UPDATE reservasi SET status='"+this.status+"' WHERE id_reservasi = "+this.idreservasi;
        DBHelper.executeQuery(SQL);
    }
    public void delete(){
        String query = "DELETE FROM reservasi WHERE id_reservasi = "+this.idreservasi;
        DBHelper.executeQuery(query);
    }
    public int getIdreservasi() {
        return idreservasi;
    }

    public void setIdreservasi(int idreservasi) {
        this.idreservasi = idreservasi;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    

    public Pesawat getPesawat() {
        return pesawat;
    }

    public void setPesawat(Pesawat Pesawat) {
        this.pesawat = Pesawat;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getHargaTiket() {
        return hargaTiket;
    }

    public void setHargaTiket(String hargaTiket) {
        this.hargaTiket = hargaTiket;
    }
  
    public String getNamaPemesan() {
        return namaPemesan;
    }

    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }
    
    public String getTglBayar() {
        return tglBayar;
    }

    public void setTglBayar(String tglBayar) {
        this.tglBayar = tglBayar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Penerbangan getPenerbangan() {
        return penerbangan;
    }

    public void setPenerbangan(Penerbangan penerbangan) {
        this.penerbangan = penerbangan;
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
    
   
}
