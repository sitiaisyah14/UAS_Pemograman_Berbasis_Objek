/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

/**
 *
 * @author WINDOWS 10
 */
import Backend.*;
public class TestBackendReservasi {
    public static void main(String[] args) {
        User user1 = User.getById(5);
        User user2 = User.getById(5);
        
        Penerbangan pb = Penerbangan.getById(9);
        Penerbangan pb1 = Penerbangan.getById(8);
        Penerbangan pb2 = Penerbangan.getById(6);
        
        Pesawat psw = Pesawat.getById(3);
        Pesawat psw2 = Pesawat.getById(8);
        
        Kota kota1 = Kota.getById(7);
        Kota kota2 = Kota.getById(2);
        Kota kota3 = Kota.getById(3);
        Kota kota4 = Kota.getById(4);
        Kota kota5 = Kota.getById(5);
        Kota kota6 = Kota.getById(6);
//        
//        Reservasi rs = new Reservasi(user2, pb1, psw2, kota1, kota2, "Ekonomi", pb1, "Deatrisya 1", pb1, null,"Belum Lunas");
        Reservasi rs = new Reservasi(user2, pb2, psw2, kota4, kota3, "Bisnis", "400000","Deatok", null, "Belum Lunas");
        Reservasi rs2= new Reservasi(user1, pb1, psw, kota4, kota3, "Ekonomi", "400000","Deatok1", null, "Belum Lunas");
        
        
//        Reservasi rs3 = new Reservasi(user1, pb, psw, kota6, kota1, "Bisnis", pb2, "Deatrisya 4", pb2, null,"Belum Lunas");
//        
        
        //test save
        rs.save();
//        rs2.save();
//        rs3.save();
        
        //test delete
//        rs.delete();
        
        //test update
        rs2.setTglBayar("2021-12-08");
        rs2.save();
        
        //test get all
        for(Reservasi r : Reservasi.getAll()){
            System.out.println("ID User : "+r.getUser().getIduser());
            System.out.println("ID Paket : "+r.getPenerbangan().getIdpaket());
            System.out.println("Kelas : "+r.getKelas());
            System.out.println("Harga Tiket : "+r.getHargaTiket());
            System.out.println("Nama Pemesan : "+r.getNamaPemesan());
            System.out.println("Asal kota : "+r.getAsalkota().getNamaKota());
            System.out.println("Tujuan kota : "+r.getTujuankota().getNamaKota());
            System.out.println("Pesawat : " + r.getPesawat().getNamaPesawat());
            System.out.println("Tanggal Berangkat : "+r.getPenerbangan().getTanggalBerangkat());
            System.out.println("Tanggal Bayar : "+r.getTglBayar());
            System.out.println("Status : "+r.getStatus());
            System.out.println();
        }
        
        //test search
        for(Reservasi r : Reservasi.search("Ekonomi")){
            System.out.println("PENCARIAN EKONOMI");
            System.out.println("ID User : "+r.getUser().getIduser());
            System.out.println("ID Paket : "+r.getPenerbangan().getIdpaket());
            System.out.println("Kelas : "+r.getKelas());
            System.out.println("Harga Tiket : "+r.getHargaTiket());
            System.out.println("Nama Pemesan : "+r.getNamaPemesan());
            System.out.println("Asal kota : "+r.getAsalkota().getNamaKota());
            System.out.println("Tujuan kota : "+r.getTujuankota().getNamaKota());
            System.out.println("Pesawat : " + r.getPesawat().getNamaPesawat());
            System.out.println("Tanggal Berangkat : "+r.getPenerbangan().getTanggalBerangkat());
            System.out.println("Tanggal Bayar : "+r.getTglBayar());
            System.out.println("Status : "+r.getStatus());
            System.out.println();
        }
    }
}
