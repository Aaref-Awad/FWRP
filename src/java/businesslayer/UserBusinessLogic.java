/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import DAO.UserDAOImpl;
import DTO.UserDTO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Handles business logic related to user management.
 */
public class UserBusinessLogic {
    private UserDAOImpl usersDao = null;

    /**
     * Constructs a UserBusinessLogic object and initializes the DAO.
     */
    public UserBusinessLogic() {
        usersDao = new UserDAOImpl();
    }

    /**
     * Retrieves all users from the database.
     *
     * @return A list of all users.
     * @throws SQLException if a database access error occurs.
     */
    public List<UserDTO> getAllUsers() throws SQLException {
        return usersDao.getAllUsers();
    }
    
    /**
     * Retrieves a user by login credentials.
     *
     * @param name The username of the user.
     * @param password The password of the user.
     * @return The user with the specified login credentials.
     */
    public UserDTO getUserByLogin(String name, String password){
        return usersDao.getUserByLogin(name, password);
    }
    
    /**
     * Retrieves a user by their ID.
     *
     * @param userId The ID of the user.
     * @return The user with the specified ID.
     */
    public UserDTO getUserById(int userId){
        return usersDao.getUserById(userId);
    }

    /**
     * Adds a user to the database.
     *
     * @param user The user to be added.
     */
    public void addUser(UserDTO user) {
        usersDao.insertUser(user);
    }
    
    /**
     * Updates the last login timestamp of a user.
     *
     * @param userId The ID of the user.
     * @param lastLogin The last login timestamp of the user.
     */
    public void updateUserLastLogin(int userId, Date lastLogin){
        usersDao.updateUserLastLogin(userId, lastLogin);
    }
    
    /**
     * Updates an existing user in the database.
     *
     * @param user The user to be updated.
     */
    public void updateUser(UserDTO user){
        usersDao.updateUser(user);
    }
}
