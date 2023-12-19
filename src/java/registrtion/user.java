/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrtion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author user
 */
@Entity
public class user implements Serializable{
    @Id
      @GeneratedValue (strategy = GenerationType.AUTO)
private int userId;
 private String usnames;
 private String Address;
 private String phonenumber;
    @Temporal(javax.persistence.TemporalType.DATE)
 private Date regdate;
 private String email;

    public user() {
    }

    public user(int userId, String usnames, String Address, String phonenumber, Date regdate, String email) {
        this.userId = userId;
        this.usnames = usnames;
        this.Address = Address;
        this.phonenumber = phonenumber;
        this.regdate = regdate;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsnames() {
        return usnames;
    }

    public void setUsnames(String usnames) {
        this.usnames = usnames;
    }

   

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 
    
    
}
