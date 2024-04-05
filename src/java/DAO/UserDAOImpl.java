package DAO;

import data.DataSource;
import DTO.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    
    private static Connection con = DataSource.getInstance().getConnection();
    private static PreparedStatement pstmt;
    private static ResultSet rs;
	
    @Override
    public List<UserDTO> getAllUsers() {
      
        ArrayList<UserDTO> users = null;

        try {
            String query = "SELECT * FROM User ORDER BY UserID";
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery();
            users = new ArrayList<>();
            while (rs.next()) {
                UserDTO user = new UserDTO();
                int userId = rs.getInt("UserID");
                user.setUserID(userId);
                
                String userType = rs.getString("UserType");
                user.setUserType(userType);
                
                String email = rs.getString("Email");
                user.setEmail(email);
                
                String username = rs.getString("Username");
                user.setUsername(username);
                
                String password = rs.getString("Password");
                user.setPassword(password);
                
                String phoneNumber = rs.getString("PhoneNumber"); // Get PhoneNumber
                user.setPhoneNumber(phoneNumber);
                
                double balance = rs.getDouble("Balance"); // Get Balance
                user.setBalance(balance);
                
                boolean isSubed = rs.getBoolean("IsSubed");
                user.setIsSubed(isSubed);
              
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return users;
    }

    @Override
    public UserDTO getUserById(int userId) {
       
        UserDTO user = null;

        try {
            
            pstmt = con.prepareStatement(
                    "SELECT * FROM User WHERE UserID = ?");
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new UserDTO();
                user.setUserType(rs.getString("UserType"));
                user.setEmail(rs.getString("Email"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setIsSubed(rs.getBoolean("IsSubed"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return user;
    }
    
    @Override
    public UserDTO getUserByLogin(String username, String password) {
        UserDTO user = null;
        try {
            pstmt = con.prepareStatement(
                    "SELECT * FROM User WHERE Username = ? AND Password = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new UserDTO();
                user.setUserID(rs.getInt("UserID"));
                user.setUserType(rs.getString("UserType"));
                user.setEmail(rs.getString("Email"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setIsSubed(rs.getBoolean("IsSubed"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return user;
    }


    @Override
    public void insertUser(UserDTO user) {
        try {
            if (!userExists(user.getUsername())) {

                pstmt = con.prepareStatement(
                        "INSERT INTO User (UserType, Email, Username, Password, PhoneNumber, IsSubed, Balance) "
                        + "VALUES( ?, ?, ?, ?, ?, ?, ?)");
                pstmt.setString(1, user.getUserType());
                pstmt.setString(2, user.getEmail());
                pstmt.setString(3, user.getUsername());
                pstmt.setString(4, user.getPassword());
                pstmt.setString(5, user.getPhoneNumber()); // Set PhoneNumber
                pstmt.setBoolean(6, user.isIsSubed());
                pstmt.setDouble(7, user.getBalance()); // Set Balance
                pstmt.executeUpdate();
              
            } else {
                throw new SQLException("User with Username " + user.getUsername()+ " already exists.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(UserDTO user) {      
        try {
            
            pstmt = con.prepareStatement(
                    "UPDATE User SET UserID=?, UserType=?, Email=?, Username=?, Password=?, PhoneNumber=?, IsSubed=?, Balance=? ");
            pstmt.setInt(1, user.getUserID());
            pstmt.setString(2, user.getUserType());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUsername());
            pstmt.setString(5, user.getPassword());
            pstmt.setString(6, user.getPhoneNumber()); // Set PhoneNumber
            pstmt.setBoolean(7, user.isIsSubed());
            pstmt.setDouble(8, user.getBalance()); // Set Balance
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(UserDTO user) {
        try {
            
            pstmt = con.prepareStatement(
                    "DELETE FROM User WHERE UserID = ?");
            pstmt.setInt(1, user.getUserID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
 
    private boolean userExists(String username) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(*) FROM User WHERE Username = ?")) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
}


