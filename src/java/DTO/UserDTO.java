package DTO;

public class UserDTO {
   private Integer UserID;
   private String UserType;
   private String Email;
   private String Username;
   private String Password;
   private String PhoneNumber; // Add PhoneNumber field
   private boolean IsSubed;
   private double Balance; // Add Balance field
   
    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer UserID) {
        this.UserID = UserID;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean isIsSubed() {
        return IsSubed;
    }

    public void setIsSubed(boolean IsSubed) {
        this.IsSubed = IsSubed;
    }
   
    public String getPhoneNumber() { // Getter for PhoneNumber
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) { // Setter for PhoneNumber
        this.PhoneNumber = PhoneNumber;
    }

    public double getBalance() { // Getter for Balance
        return Balance;
    }

    public void setBalance(double Balance) { // Setter for Balance
        this.Balance = Balance;
    }
}
