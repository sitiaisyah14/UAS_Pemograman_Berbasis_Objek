/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import java.sql.Date;

/**
 *
 * @author WINDOWS 10
 */
public class Tanggal {
   
    public static Date getTanggalSekarang() {
        long millis = System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
        System.out.println(date);  
        return date;
    }

    public static void main(String[] args) {
        Tanggal tgl = new Tanggal();
        tgl.getTanggalSekarang();
    }
}
