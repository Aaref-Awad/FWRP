/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import DAO.UserDAOImpl;
import DTO.UserDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aaref
 */
public class UserBusinessLogic {
    private UserDAOImpl usersDao = null;

    public UserBusinessLogic() {
        usersDao = new UserDAOImpl();
    }

    public List<UserDTO> getAllUsers() throws SQLException {
        return usersDao.getAllUsers();
    }
    
    public UserDTO getUserByUsername(String name){
        return usersDao.getUserByUsername(name);
    }

    public void addUser(UserDTO user) {
        usersDao.insertUser(user);
    } 
}
