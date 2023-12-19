/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;




import dao.GenericDao;
import dao.IgenericDao;
import java.security.NoSuchAlgorithmException;
import controller.JSFManagedBeanLogin;
import java.security.MessageDigest;



/**
 *
 * @author user
 */
public class test {
        public static void main(String[] args) throws NoSuchAlgorithmException  {
        userAccess n=new userAccess();
      n.setEmail("abayo@carerent.rw");
      n.setPassoword(criptPassword("CarAdmin"));
   //   usacc.setPassoword(criptPassword(usacc.getPassoword()));
      n.setType("Admin");
//      n.setStaffPassword(new JSFManagedBeanUser().criptPassword("GIES Admin"));
      n.setActive("Yes");
    IgenericDao st=new GenericDao();
    st.create(n);
    
    }
        public static String criptPassword(String password) throws NoSuchAlgorithmException {

        String pas = password;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pas.getBytes());
        byte byteData[] = md.digest();
     // StringBuffer sba = new StringBuffer();
      StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return (sb.toString());
    }
}
