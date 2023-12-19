/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Access.userAccess;
import Car.CarRent;
import Car.cardetails;
import dao.GenericDao;
import dao.IgenericDao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import registrtion.user;

/**
 *
 * @author user
 */

@ManagedBean(name = "useManagedBeanLogin")
//@RequestScoped
@Named (value = "useManagedBeanLogin")
//@Dependent
@SessionScoped
public class JSFManagedBeanLogin {
    
    GenericDao dao1=new GenericDao();
private user us= new user();

    public user getUs() {
        return us;
    }

    public void setUs(user us) {
        this.us = us;
    }
    private userAccess usacc=new userAccess();

    public userAccess getUsacc() {
        return usacc;
    }

    public void setUsacc(userAccess usacc) {
        this.usacc = usacc;
    }
    IgenericDao dao=new GenericDao();
 public void rusercreation() throws NoSuchAlgorithmException{
     usacc.setPassoword(criptPassword(usacc.getPassoword()));
     System.out.println("in ");
     long mil=System.currentTimeMillis();
     java.sql.Date date=new java.sql.Date(mil);
     System.out.println(date);
     us.setRegdate(date);
dao.create(us);
System.out.println("out ");
usacc.setEmail(us.getEmail());
usacc.setActive("Yes");
usacc.setType("Client");
usacc.setUserId(us.getUserId());
dao.create(usacc);
//     return null;
 
 }   
public String loging(){
    try {
       usacc.setPassoword(criptPassword(usacc.getPassoword()));
      //  System.out.println("email is "+usacc.getEmail());
       // System.out.println("password is "+usacc.getPassoword());
        Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrent_db?useSSL=false", "root", "Florence@123");
          //  System.out.println("connected");
            String qr = "select * from userAccess where Email ='"+usacc.getEmail()+"' and Passoword='"+usacc.getPassoword()+"'";
           // System.out.println("out of quesl");
            PreparedStatement pst = con.prepareStatement(qr);
            pst.execute();
            ResultSet rs = pst.getResultSet();
            userAccess one=new userAccess();
            
     //   System.out.println("out of db");
            while(rs.next() ){
          //  Email type active
          one.setEmail(rs.getString("Email"));
          one.setType(rs.getString("type"));
          one.setActive(rs.getString("active"));
          one.setUserId(rs.getInt("userId"));
            }
            us.setUserId(one.getUserId());
            // System.out.println("out of loop"+one.getActive());
            if(one.getActive().equals("Yes")){
              //  System.out.println("insed if "+us.getUserId());
              //  System.out.println("type if "+one.getType());
                switch(one.getType()){
                    case "Client":
                     //   System.out.println("in client");
           us=dao1.getOneUser(us.getUserId());
            //System.out.println(" client is"+us.getUsnames());
                        return "Client/index.xhtml?faces-redirect=true";
                        //break;
                    case "Admin":
                        us.setEmail(one.getEmail());
                        us.setUsnames("Admin");
                        return "Admin/index.xhtml?faces-redirect=true";
                       // break;
                    default:
                      return "index.xhtml?faces-redirect=true";
           }
            }
        
    } 
    catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    return null;
}

    
    // cardetails


private cardetails ca=new cardetails();

    public cardetails getCa() {
        return ca;
    }

    public void setCa(cardetails ca) {
        this.ca = ca;
    }
public void regcar(){
    ca.setStatus("Available");
dao.create(ca);
}
private List<CarRent> carll=new ArrayList<>();

    public List<CarRent> getCarll() {
        carll=dao.getAll("from CarRent where customernumber='"+us.getUserId()+"'");
        return carll;
    }

    public void setCarll(List<CarRent> carll) {
        this.carll = carll;
    }

    private List<cardetails> carl=new ArrayList<>();

    public List<cardetails> getCarl() {
      carl=dao.getAll("from cardetails");
        return carl;
    }

    public void setCarl(List<cardetails> carl) {
        this.carl = carl;
    }
     private List<cardetails> carA=new ArrayList<>();

    public List<cardetails> getCarA() {
        
        
      carA=dao.getAll("from cardetails where Status like'%Available%'");
        return carA;
    }

    public void setCarA(List<cardetails> carA) {
        this.carA = carA;
    }
    private CarRent carre=new CarRent();
    public CarRent getCarre() {
        return carre;
    }

    public void setCarre(CarRent carre) {
        this.carre = carre;
    }
    
     public String upCar(int id){
    ca=dao1.getOneCar(id);
    carre.setCarid(ca.getNum());
    return "bookcar.xhtml";
    }
     public String upCar2(int id){
    ca=dao1.getOneCar(id);
ca.setStatus("Booked");
dao.update(ca);
    return "bookcar.xhtml";
    }
     public String regcarrent()throws ParseException{
         
          // System.out.println("Car ID  is"+carre.getCarid());
long dateBeforeInMs = carre.getReturndate().getTime();
long dateAfterInMs = carre.getRentdate().getTime();

long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);

long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
//System.out.println("Day are"+daysDiff);           
int  g=(int) (daysDiff * ca.getPrice());
     carre.setFees(g);
     carre.setStatus("Borrowed");
     carre.setCustomernumber(us.getUserId());
     dao.create(carre);
         upCar2(carre.getCarid());
         return "Carlist.xhtml";
     }
     private List<CarRent> carerelist=new ArrayList<>();
   

    public List<CarRent> getCarerelist() {
        carerelist=dao.getAll("from CarRent");
        return carerelist;
    }

    public void setCarerelist(List<CarRent> carerelist) {
        this.carerelist = carerelist;
    }
      public String upCarretu(int id){
    carre=dao1.getOneCarrent(id);
    long mil=System.currentTimeMillis();
    java.sql.Date date=new java.sql.Date(mil);
    carre.setReturneddate(date);
    if(date.compareTo(carre.getReturndate())>0){
    
    long dateBeforeInMs = carre.getReturndate().getTime();
    long dateAfterInMs = carre.getReturneddate().getTime();

    long timeDiff = Math.abs(dateBeforeInMs - dateAfterInMs);

    long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
    System.out.println("Day are"+daysDiff);           
    int  g=(int) (daysDiff *50000);

     carre.setFine(g);
    }
    else {
        carre.setFine(0);
    }
    
     carre.setStatus("Returned");
     dao.update(carre);
          upCar3(carre.getCarid());
    //carre.setCarid(ca.getNum());
    return "Rentedlist.xhtml";
    }
     public String upCar3(int id){
    ca=dao1.getOneCar(id);
ca.setStatus("Available");
dao.update(ca);
    return "bookcar.xhtml";
    }
    // User Management
    private List<userAccess> userlist= new ArrayList<>();

    public List<userAccess> getUserlist() {
        userlist = dao.getAll("from userAccess");
        return userlist;
    }

    public void setUserlist(List<userAccess> userlist) {
        this.userlist = userlist;
    }
     public String updateuser(int id){
         
         usacc= dao1.getOneUserAccess(id);
         
         if(usacc.getActive().equals("Yes"))
         {usacc.setActive("No");}
         else{
             usacc.setActive("Yes");}
         
         dao.update(usacc);
        return "UserList.xhtml";
         
     }
    
   
    
    /**
     * Creates a new instance of JSFManagedBeanLogin
     */
    public JSFManagedBeanLogin() {
    }
    public String criptPassword(String password) throws NoSuchAlgorithmException {

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
