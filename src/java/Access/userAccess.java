/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author user
 */
@Entity
public class userAccess implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int Id;
    private String Email;
    private String Passoword;
    private String active;
    private String type;
    private int userId;

    public userAccess() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    

    public userAccess(int Id, String Email, String Passoword, String active, String type, int userId) {
        this.Id = Id;
        this.Email = Email;
        this.Passoword = Passoword;
        this.active = active;
        this.type = type;
        this.userId = userId;
    }

    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassoword() {
        return Passoword;
    }

    public void setPassoword(String Passoword) {
        this.Passoword = Passoword;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
