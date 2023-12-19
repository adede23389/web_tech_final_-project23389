/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car;

import java.io.Serializable;
import java.text.DecimalFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author user
 */
@Entity
public class cardetails implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int num;
    private String platenumber;
    private String brand;
    private String model;
    private String Status;
    private int price;
    
    public cardetails() {
    }

    public cardetails(int num, String platenumber, String brand, String model, String Status, int price) {
        this.num = num;
        this.platenumber = platenumber;
        this.brand = brand;
        this.model = model;
        this.Status = Status;
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPlatenumber() {
        return platenumber;
    }

    public void setPlatenumber(String platenumber) {
        this.platenumber = platenumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(price < 0){
            throw new RuntimeException("Invalid amount");
        }
        this.price = price;
    }
    
    public String getPriceFormatted(){
        DecimalFormat df = new DecimalFormat("FRW ###,###.00");
        return df.format(price);
    }
    
}
