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
public class TestBackendPesawat {
    public static void main(String[] args) {
        Maskapai maskapai1 = Maskapai.getById(2);
        Maskapai maskapai2 = Maskapai.getById(3);
        
        Pesawat psw1 = new Pesawat("Boeing 737", maskapai1);
        Pesawat psw2 = new Pesawat("Boeing 737",maskapai1);
        Pesawat psw3 = new Pesawat("Airbus A329",maskapai2);
        
        //test insert
        psw1.save();
        psw2.save();
        psw3.save();
        
        //test update
        psw3.setNamaPesawat("Airbus A320");
        psw3.save();
        
        //test delete
        psw1.delete();
        
        //test select all
        for(Pesawat psw : Pesawat.getAll()){
            System.out.println("Nama Pesawat : "+psw.getNamaPesawat() + " Nama Maskapai : "+psw.getMaskapai().getNamaPerusahaan());
        }
        
        //test search
         for(Pesawat psw : Pesawat.search("Boeing 737")){
            System.out.println("Nama Pesawat : "+psw.getNamaPesawat() + " Nama Maskapai : "+psw.getMaskapai().getNamaPerusahaan());
        }
    }
}
