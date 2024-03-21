/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Owner
 */
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
                user.setEmail(username);
                
                String password = rs.getString("Password");
                user.setEmail(password);
                
                boolean isSubbed = rs.getBoolean("IsSubed");
                user.setIsSubed(isSubbed);
              
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
    public UserDTO getUserByUsername(String username) {
        UserDTO user = null;
        try {
            pstmt = con.prepareStatement(
                    "SELECT * FROM User WHERE Username = ?");
            pstmt.setString(1, username);
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
    public void insertUser(UserDTO user) {
        try {
            if (!userExists(user.getUsername())) {

                pstmt = con.prepareStatement(
                        "INSERT INTO User (UserType, Email, Username, Password, IsSubed) "
                        + "VALUES( ?,?, ?, ?, ?)");
                pstmt.setString(1, user.getUserType());
                pstmt.setString(2, user.getEmail());
                pstmt.setString(3, user.getUsername());
                pstmt.setString(4, user.getPassword());
                pstmt.setBoolean(5, user.isIsSubed());
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
                    "UPDATE User SET UserID=? , UserType=?, Email=?, Username=?, Password=?, IsSubed=? ");
            pstmt.setInt(1, user.getUserID());
            pstmt.setString(2, user.getUserType());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUsername());
            pstmt.setString(5, user.getPassword());
            pstmt.setBoolean(6, user.isIsSubed());
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


