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
public class TestBackendUser {
    public static void main(String[] args) {
        User user1 = new User("penumpang1","123456","Deatrisya MH" 
                ,"2001-12-18", "P", "Purwosari", "081330991"
                ,"mirelldee47@gmail.com");
        User user2 = new User("penumpang2","123456","Aisyah" 
                ,"2001-12-18", "P", "Sukorejo", "081330991"
                ,"aisyah@gmail.com");
        User user3 = new User("penumpang3","penumpang","Penumpang" 
                ,"2001-12-18", "P", "Sukorejo", "081330991"
                ,"Penumpang@gmail.com");
        
        //test insert
        user1.save();
        user2.save();
        user3.save();
        
        //testUpdate
        user2.setAlamatUser("Malang");
        user2.setNamaUser("Siti Aisyah");
        user2.save();
        
        //test delete
        user1.delete();
        
        //test select all
        for(User user : User.getAll()){
            System.out.println("=================");
            System.out.println("Username : "+user.getUsernameUser());
            System.out.println("Password : "+user.getPasswordUser());
            System.out.println("Nama : "+user.getNamaUser());
            System.out.println("Tangga Lahir : "+user.getTglLahir());
            System.out.println("Jenis Kelamin : "+user.getJenisKelamin());
            System.out.println("Alamat : "+user.getAlamatUser());
            System.out.println("Telepon : "+user.getNo_telepon());
            System.out.println("Email : "+user.getEmailUser());
        }
        
        //test search
        for(User user : User.search("Deatrisya")){
            System.out.println("=================");
            System.out.println("Username : "+user.getUsernameUser());
            System.out.println("Password : "+user.getPasswordUser());
            System.out.println("Nama : "+user.getNamaUser());
            System.out.println("Tangga Lahir : "+user.getTglLahir());
            System.out.println("Jenis Kelamin : "+user.getJenisKelamin());
            System.out.println("Alamat : "+user.getAlamatUser());
            System.out.println("Telepon : "+user.getNo_telepon());
            System.out.println("Email : "+user.getEmailUser());
        }
    }
}
