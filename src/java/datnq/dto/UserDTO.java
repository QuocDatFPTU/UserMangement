/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datnq.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Quoc Dat
 */
public class UserDTO implements Serializable{

    private String userID;
    private String name;
    private String password;
    private String phone;
    private String address;
    private Date createDate;
    private int roleID;
    private int statusID;

    public UserDTO() {
    }
    
    public UserDTO(String userID, String name, String password, String phone, String address, Date createDate, int roleID, int statusID) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.createDate = createDate;
        this.roleID = roleID;
        this.statusID = statusID;
    }

    public UserDTO(String userID, String password, String name, int roleID) {
        this.userID = userID;
        this.password = password;
        this.name = name;
        this.roleID = roleID;
    }

    public UserDTO(String userID, String name, String phone, String address) {
        this.userID = userID;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    
    
    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", name=" + name + ", password=" + password + ", phone=" + phone + ", address=" + address + ", createDate=" + createDate + ", roleID=" + roleID + ", statusID=" + statusID + '}';
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

}
