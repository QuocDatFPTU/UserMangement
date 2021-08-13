/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datnq.dto;

import java.io.Serializable;

/**
 *
 * @author Quoc Dat
 */
public class UserError implements Serializable{
    private String userIDError;    
    private String nameError;
    private String phoneError;
    private String addressError;
    private String passwordError;
    private String confirmPasswordError;

    public UserError(String userIDError, String nameError, String phoneError, String addressError, String passwordError, String confirmPasswordError) {
        this.userIDError = userIDError;
        this.nameError = nameError;
        this.phoneError = phoneError;
        this.addressError = addressError;
        this.passwordError = passwordError;
        this.confirmPasswordError = confirmPasswordError;
    }

    public UserError() {
       
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmPasswordError() {
        return confirmPasswordError;
    }

    public void setConfirmPasswordError(String confirmPasswordError) {
        this.confirmPasswordError = confirmPasswordError;
    }
    
    
}
