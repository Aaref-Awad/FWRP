package DTO;

import java.util.Date;

public class UserDTO {
   private Integer userID;
   private String userType;
   private String email;
   private String username;
   private String password;
   private String phoneNumber;
   private boolean isSubed;
   private double balance;
   private Date lastLogin; // Add LastLogin field
   
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSubed() {
        return isSubed;
    }

    public void setSubed(boolean isSubed) {
        this.isSubed = isSubed;
    }
   
    public String getPhoneNumber() { // Getter for PhoneNumber
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) { // Setter for PhoneNumber
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() { // Getter for Balance
        return balance;
    }

    public void setBalance(double balance) { // Setter for Balance
        this.balance = balance;
    }
    
    public Date getLastLogin() { // Getter for LastLogin
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) { // Setter for LastLogin
        this.lastLogin = lastLogin;
    }
}
