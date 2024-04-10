package DTO;

import java.util.Date;

/**
 * Data Transfer Object (DTO) representing a user.
 */
public class UserDTO {
    private Integer userID; // The user's ID
    private String userType; // The type of user
    private String email; // The user's email address
    private String username; // The user's username
    private String password; // The user's password
    private String phoneNumber; // The user's phone number
    private boolean isSubed; // Whether the user is subscribed or not
    private double balance; // The user's balance
    private Date lastLogin; // The date of the user's last login

    /**
     * Retrieves the user ID.
     *
     * @return the user ID
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Sets the user ID.
     *
     * @param userID the user ID to set
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * Retrieves the user type.
     *
     * @return the user type
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the user type.
     *
     * @param userType the user type to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Retrieves the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber the phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Checks if the user is subscribed.
     *
     * @return true if the user is subscribed, otherwise false
     */
    public boolean isSubed() {
        return isSubed;
    }

    /**
     * Sets the subscription status.
     *
     * @param isSubed true if the user is subscribed, otherwise false
     */
    public void setSubed(boolean isSubed) {
        this.isSubed = isSubed;
    }

    /**
     * Retrieves the balance.
     *
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance.
     *
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Retrieves the last login date.
     *
     * @return the last login date
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * Sets the last login date.
     *
     * @param lastLogin the last login date to set
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
