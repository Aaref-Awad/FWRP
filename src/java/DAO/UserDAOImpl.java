package DAO;

import DTO.UserDTO;
import data.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
                user.setUserID(rs.getInt("UserID"));
                user.setUserType(rs.getString("UserType"));
                user.setEmail(rs.getString("Email"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setSubed(rs.getBoolean("IsSubed"));
                user.setBalance(rs.getDouble("Balance"));
                user.setLastLogin(rs.getTimestamp("LastLogin")); // Set LastLogin
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                user.setUserID(rs.getInt("UserID"));
                user.setUserType(rs.getString("UserType"));
                user.setEmail(rs.getString("Email"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setSubed(rs.getBoolean("IsSubed"));
                user.setBalance(rs.getDouble("Balance"));
                user.setLastLogin(rs.getTimestamp("LastLogin")); // Set LastLogin
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setSubed(rs.getBoolean("IsSubed"));
                user.setBalance(rs.getDouble("Balance"));
                user.setLastLogin(rs.getTimestamp("LastLogin")); // Set LastLogin
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public void insertUser(UserDTO user) {
        try {
            if (!userExists(user.getUsername())) {

                pstmt = con.prepareStatement(
                        "INSERT INTO User (UserType, Email, Username, Password, PhoneNumber, IsSubed, Balance, LastLogin) "
                                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                pstmt.setString(1, user.getUserType());
                pstmt.setString(2, user.getEmail());
                pstmt.setString(3, user.getUsername());
                pstmt.setString(4, user.getPassword());
                pstmt.setString(5, user.getPhoneNumber());
                pstmt.setBoolean(6, user.isSubed());
                pstmt.setDouble(7, user.getBalance());
                pstmt.setTimestamp(8, new java.sql.Timestamp(user.getLastLogin().getTime())); // Set LastLogin
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
                    "UPDATE User SET UserType=?, Email=?, Username=?, Password=?, PhoneNumber=?, IsSubed=?, Balance=?, LastLogin=? WHERE UserID=?");
            pstmt.setString(1, user.getUserType());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getPhoneNumber());
            pstmt.setBoolean(6, user.isSubed());
            pstmt.setDouble(7, user.getBalance());
            pstmt.setTimestamp(8, new java.sql.Timestamp(user.getLastLogin().getTime())); // Set LastLogin
            pstmt.setInt(9, user.getUserID());
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
    
    @Override
    public void updateUserLastLogin(int userId, Date lastLogin) {
        try {
            pstmt = con.prepareStatement("UPDATE User SET LastLogin = ? WHERE UserID = ?");
            pstmt.setTimestamp(1, new java.sql.Timestamp(lastLogin.getTime()));
            pstmt.setInt(2, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
