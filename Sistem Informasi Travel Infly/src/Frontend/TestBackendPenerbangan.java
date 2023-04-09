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
public class TestBackendPenerbangan {
    public static void main(String[] args) {
        Kota kota = Kota.getById(2);
        Kota kota2 = Kota.getById(3);
        
        Pesawat psw = Pesawat.getById(2);
        Pesawat psw2 = Pesawat.getById(3);
        Pesawat psw3 = Pesawat.getById(5);
        
        Maskapai maskapai = Maskapai.getById(2);
        Maskapai maskapai1 = Maskapai.getById(3);
        
        Penerbangan pb = new Penerbangan(kota, kota2, psw3,maskapai, 400000,"09:12:34","09:12:39", "2021-12-08");
        Penerbangan pb1 = new Penerbangan(kota, kota2, psw2,maskapai1, 400000,"09:12:34","09:12:39", "2021-12-08");
        Penerbangan pb2 = new Penerbangan(kota, kota2, psw,maskapai, 400000,"09:12:34","09:12:39", "2021-12-08");
        
        //test insert
        pb.save();
        pb1.save();
        pb2.save();
//        
        //test update
        pb.setAsalkota(kota2);
        pb.setTujuankota(kota);
        pb.save();
        
        pb.setJamBerangkat("09:40:30");
        pb.setAsalkota(kota2);
        pb.setTujuankota(kota);
        pb.save();
        
        //test delete
        pb2.delete();
        
        //test getall
        for(Penerbangan p : Penerbangan.getAll()){
            System.out.println("Asal Kota : "+p.getAsalkota().getNamaKota());
            System.out.println("Tujuan Kota : "+p.getTujuankota().getNamaKota());
            System.out.println("Nama Pesawat : "+p.getPesawat().getNamaPesawat());
            System.out.println("Nama Maskapai : "+p.getMaskapai().getNamaPerusahaan());
            System.out.println("Harga : " + p.getHargaTiket());
            System.out.println("Jam Berangkat : "+p.getJamBerangkat());
            System.out.println("Jam Kedatangan : "+p.getJamKedatangan());
            System.out.println("Tanggal Berangkat : " + p.getTanggalBerangkat());
            System.out.println();
        }
        //test search        
        for(Penerbangan p : Penerbangan.search("Jakarta")){
            System.out.println("PENCARIAN KOTA");
            System.out.println("Asal Kota : "+p.getAsalkota().getNamaKota());
            System.out.println("Tujuan Kota : "+p.getTujuankota().getNamaKota());
            System.out.println("Nama Pesawat : "+p.getPesawat().getNamaPesawat());
            System.out.println("Nama Maskapai : "+p.getMaskapai().getNamaPerusahaan());
            System.out.println("Harga : " + p.getHargaTiket());
            System.out.println("Jam Berangkat : "+p.getJamBerangkat());
            System.out.println("Jam Kedatangan : "+p.getJamKedatangan());
            System.out.println("Tanggal Berangkat : " + p.getTanggalBerangkat());
            System.out.println();
        } 
    }
}
