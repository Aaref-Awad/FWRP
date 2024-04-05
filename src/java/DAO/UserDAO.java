/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.UserDTO;
import java.util.List;

/**
 *
 * @author Owner
 */
public interface UserDAO {
     // CRUD operations
    public List<UserDTO> getAllUsers();
    public UserDTO getUserById(int userId);
    public UserDTO getUserByLogin(String username, String password);
    public void insertUser(UserDTO user);
    public void updateUser(UserDTO user);
    public void deleteUser(UserDTO user);
}
