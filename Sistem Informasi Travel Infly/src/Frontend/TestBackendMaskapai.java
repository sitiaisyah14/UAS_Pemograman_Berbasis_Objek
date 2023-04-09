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
public class TestBackendMaskapai {
    public static void main(String[] args) {
        Maskapai maskapai1 = new Maskapai("Indonesia Airlines");
        Maskapai maskapai2 = new Maskapai("Garuda Indonesia");
        Maskapai maskapai3 = new Maskapai("Sky Aviation");
        
        //test insert
        maskapai1.save();
        maskapai2.save();
        maskapai3.save();
        
        //test update
        maskapai2.setNamaPerusahaan("Air Asia");
        maskapai2.save();
        
        //test delete
        maskapai1.delete();
        
        //test select all
        for(Maskapai maskapai : Maskapai.getAll()){
            System.out.println("Nama Maskapai : "+maskapai.getNamaPerusahaan());
        }
        
        //test search
         for(Maskapai maskapai : Maskapai.search("Indonesia Airlines")){
            System.out.println("Nama Maskapai : "+maskapai.getNamaPerusahaan());
        }
    }
}
