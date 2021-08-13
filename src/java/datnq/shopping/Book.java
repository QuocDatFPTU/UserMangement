/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datnq.shopping;

import java.sql.Date;

/**
 *
 * @author Quoc Dat
 */
public class Book {
    private int productID;
    private String productName;
    private String description;
    private float price;
    private int quantity;
    private int statusID;
    private Date createDate;
    private String img;

     public Book() {
    }
    
    public Book(int productID, String productName, String description, float price, int quantity, int statusID, Date createDate, String img) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.statusID = statusID;
        this.createDate = createDate;
        this.img = img;
    }

    public Book(String productName, String description, float price, int quantity, Date createDate, String img) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.createDate = createDate;
        this.img = img;
    }
    
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
}
