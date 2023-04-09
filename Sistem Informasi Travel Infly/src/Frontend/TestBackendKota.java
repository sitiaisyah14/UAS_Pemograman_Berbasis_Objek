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
public class TestBackendKota {
    public static void main(String[] args) {
        Kota kota1 = new Kota("Surabaya");
        Kota kota2 = new Kota("Malang");
        Kota kota3 = new Kota("Jakarta");
        
        //test insert
        kota1.save();
        kota2.save();
        kota3.save();
        
        //test update
        kota2.setNamaKota("Padang");
        kota2.save();
        
        //test delete
        kota1.delete();
        
        //test select all
        for(Kota kota : Kota.getAll()){
            System.out.println("Nama Kota : "+kota.getNamaKota());
        }
        
        //test search
         for(Kota kota : Kota.search("Jakarta")){
            System.out.println("Nama Kota : "+kota.getNamaKota());
        }
    }
}
