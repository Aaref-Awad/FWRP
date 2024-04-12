package DTO;

import java.util.Date;

/**
 * Represents a user in the system.
 */
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

    /**
     * Retrieves the ID of the user.
     *
     * @return The ID of the user.
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Sets the ID of the user.
     *
     * @param userID The ID of the user.
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * Retrieves the type of the user.
     *
     * @return The type of the user.
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the type of the user.
     *
     * @param userType The type of the user.
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Retrieves the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The email address of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the username of the user.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username The username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Checks if the user is subscribed.
     *
     * @return true if the user is subscribed, false otherwise.
     */
    public boolean isSubed() {
        return isSubed;
    }

    /**
     * Sets the subscription status of the user.
     *
     * @param isSubed true if the user is subscribed, false otherwise.
     */
    public void setSubed(boolean isSubed) {
        this.isSubed = isSubed;
    }

    /**
     * Retrieves the phone number of the user.
     *
     * @return The phone number of the user.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phoneNumber The phone number of the user.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Retrieves the balance of the user.
     *
     * @return The balance of the user.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the user.
     *
     * @param balance The balance of the user.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Retrieves the last login timestamp of the user.
     *
     * @return The last login timestamp of the user.
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * Sets the last login timestamp of the user.
     *
     * @param lastLogin The last login timestamp of the user.
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
