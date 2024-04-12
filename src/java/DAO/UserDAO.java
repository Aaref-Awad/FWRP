/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.UserDTO;
import java.util.Date;
import java.util.List;

/**
 * The UserDAO interface provides methods for performing CRUD operations on UserDTO objects.
 */
public interface UserDAO {
     /**
     * Retrieves a list of all users.
     *
     * @return A list of UserDTO objects representing all users in the database.
     */
    public List<UserDTO> getAllUsers();
    
    /**
     * Retrieves a user by their ID.
     *
     * @param userId The ID of the user to retrieve.
     * @return The UserDTO object representing the user with the given ID, or null if no user is found.
     */
    public UserDTO getUserById(int userId);
    
    /**
     * Retrieves a user by their login credentials.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The UserDTO object representing the user with the given login credentials, or null if no user is found.
     */
    public UserDTO getUserByLogin(String username, String password);
    
    /**
     * Inserts a new user into the database.
     *
     * @param user The UserDTO object representing the user to insert.
     */
    public void insertUser(UserDTO user);
    
    /**
     * Updates an existing user in the database.
     *
     * @param user The UserDTO object representing the user to update.
     */
    public void updateUser(UserDTO user);
    
    /**
     * Deletes a user from the database.
     *
     * @param user The UserDTO object representing the user to delete.
     */
    public void deleteUser(UserDTO user);
    
    /**
     * Updates the last login date of a user.
     *
     * @param userId The ID of the user whose last login date to update.
     * @param lastLogin The new last login date of the user.
     */
    public void updateUserLastLogin(int userId, Date lastLogin);

}
