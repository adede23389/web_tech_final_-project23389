/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car;

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
public class CarRent implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rentid;
    private int carid;
    private int customernumber;
   @Temporal(javax.persistence.TemporalType.DATE)
    private Date rentdate;
@Temporal(javax.persistence.TemporalType.DATE)
    private Date returndate;
    private int fees;
    private String status;
    private int fine;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date returneddate;
   // rentid, registration, customername, rentdate, returndate, fees

    public CarRent() {
    }

    public CarRent(int rentid, int carid, int customernumber, Date rentdate, Date returndate, int fees, String status, int fine, Date returneddate) {
        this.rentid = rentid;
        this.carid = carid;
        this.customernumber = customernumber;
        this.rentdate = rentdate;
        this.returndate = returndate;
        this.fees = fees;
        this.status = status;
        this.fine = fine;
        this.returneddate = returneddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public Date getReturneddate() {
        return returneddate;
    }

    public void setReturneddate(Date returneddate) {
        this.returneddate = returneddate;
    }

    
    public int getRentid() {
        return rentid;
    }

    public void setRentid(int rentid) {
        this.rentid = rentid;
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public int getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(int customernumber) {
        this.customernumber = customernumber;
    }

    public Date getRentdate() {
        return rentdate;
    }

    public void setRentdate(Date rentdate) {
        this.rentdate = rentdate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }
    
}
