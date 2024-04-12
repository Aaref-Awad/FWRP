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

/**
 * This class provides implementation for accessing user data in a database.
 */
public class UserDAOImpl implements UserDAO {

    private static Connection con = DataSource.getInstance().getConnection();
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    /**
     * Retrieves all users from the database.
     *
     * @return A list of UserDTO objects representing all users in the database.
     */
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

    /**
     * Retrieves a user from the database by their ID.
     *
     * @param userId The ID of the user to retrieve.
     * @return A UserDTO object representing the user with the specified ID, or null if not found.
     */
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

    /**
     * Retrieves a user from the database by their login credentials.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return A UserDTO object representing the user with the specified login credentials, or null if not found.
     */
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


    /**
     * Inserts a new user into the database.
     *
     * @param user The UserDTO object representing the user to be inserted.
     */
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
                pstmt.setTimestamp(8, new java.sql.Timestamp(System.currentTimeMillis())); // Set LastLogin
                pstmt.executeUpdate();

            } else {
                throw new SQLException("User with Username " + user.getUsername()+ " already exists.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing user in the database.
     *
     * @param user The UserDTO object representing the user to be updated.
     */
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

     /**
     * Deletes a user from the database.
     *
     * @param user The UserDTO object representing the user to be deleted.
     */
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

    /**
     * Checks if a user with the specified username already exists in the database.
     *
     * @param username The username to check for existence.
     * @return true if the user exists, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
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
    
    /**
     * Updates the last login timestamp of a user in the database.
     *
     * @param userId    The ID of the user.
     * @param lastLogin The new last login timestamp.
     */
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
