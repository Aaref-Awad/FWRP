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
    
    public UserDTO getUserByLogin(String name, String password){
        return usersDao.getUserByLogin(name, password);
    }
    
    public UserDTO getUserById(int userId){
        return usersDao.getUserById(userId);
    }

    public void addUser(UserDTO user) {
        usersDao.insertUser(user);
    }
    
    public void updateUserLastLogin(int userId, Date lastLogin){
        usersDao.updateUserLastLogin(userId, lastLogin);
    }
    
    public void updateUser(UserDTO user){
        usersDao.updateUser(user);
    }
}
