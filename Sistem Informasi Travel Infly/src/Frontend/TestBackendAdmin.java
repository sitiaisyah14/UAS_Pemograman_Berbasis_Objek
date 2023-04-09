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
public class TestBackendAdmin {
    public static void main(String[] args) {
        Admin admin1 = new Admin("deatrisya","123456","Deatrisya MH" 
                ,"2001-12-18", "P", "Purwosari", "081330991"
                ,"mirelldee47@gmail.com");
        Admin admin2 = new Admin("sitiaisyah","123456","Aisyah" 
                ,"2001-12-18", "P", "Sukorejo", "081330991"
                ,"aisyah@gmail.com");
        Admin admin3 = new Admin("admin","admin","Admin" 
                ,"2001-12-18", "P", "Sukorejo", "081330991"
                ,"admin@gmail.com");
        
        //test insert
        admin1.save();
        admin2.save();
        admin3.save();
        
        //testUpdate
        admin2.setAlamatAdmin("Malang");
        admin2.setNamaAdmin("Siti Aisyah");
        admin2.save();
        
        //test delete
        admin3.delete();
        
        //test select all
        for(Admin adm : Admin.getAll()){
            System.out.println("=================");
            System.out.println("Username : "+adm.getUsernameAdmin());
            System.out.println("Password : "+adm.getPasswordAdmin());
            System.out.println("Nama : "+adm.getNamaAdmin());
            System.out.println("Tangga Lahir : "+adm.getTglLahir());
            System.out.println("Jenis Kelamin : "+adm.getJenisKelamin());
            System.out.println("Alamat : "+adm.getAlamatAdmin());
            System.out.println("Telepon : "+adm.getNo_telepon());
            System.out.println("Email : "+adm.getEmailAdmin());
        }
        
        //test search
        for(Admin adm : Admin.search("Deatrisya")){
            System.out.println("=================");
            System.out.println("Username : "+adm.getUsernameAdmin());
            System.out.println("Password : "+adm.getPasswordAdmin());
            System.out.println("Nama : "+adm.getNamaAdmin());
            System.out.println("Tangga Lahir : "+adm.getTglLahir());
            System.out.println("Jenis Kelamin : "+adm.getJenisKelamin());
            System.out.println("Alamat : "+adm.getAlamatAdmin());
            System.out.println("Telepon : "+adm.getNo_telepon());
            System.out.println("Email : "+adm.getEmailAdmin());
        }
    }
}
