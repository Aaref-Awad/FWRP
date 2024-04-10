package businesslayer;

import DAO.UserDAOImpl;
import DTO.UserDTO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Business logic layer for User operations.
 */
public class UserBusinessLogic {
    private UserDAOImpl usersDao = null;

    /**
     * Initializes a new instance of the UserBusinessLogic class.
     */
    public UserBusinessLogic() {
        usersDao = new UserDAOImpl();
    }
    
    /**
     * Validates a user before adding.
     *
     * @param user the UserDTO object to validate
     * @return the validated UserDTO object
     * @throws ValidationException if validation fails
     */
    public UserDTO validateUser(UserDTO user) throws ValidationException {
        return Validator.validateUser(user);
    }
    
    /**
     * Retrieves all users.
     *
     * @return a list of UserDTO representing all users
     * @throws SQLException if a database access error occurs
     */
    public List<UserDTO> getAllUsers() throws SQLException {
        return usersDao.getAllUsers();
    }
    
    /**
     * Retrieves a user by login credentials.
     *
     * @param name the username
     * @param password the password
     * @return the UserDTO representing the user with the provided login credentials
     */
    public UserDTO getUserByLogin(String name, String password){
        return usersDao.getUserByLogin(name, password);
    }
    
    /**
     * Retrieves a user by its ID.
     *
     * @param userId the ID of the user
     * @return the UserDTO representing the user with the specified ID
     */
    public UserDTO getUserById(int userId){
        return usersDao.getUserById(userId);
    }

    /**
     * Adds a new user.
     *
     * @param user the UserDTO representing the user to add
     */
    public void addUser(UserDTO user) {
        usersDao.insertUser(user);
    }
    
    /**
     * Updates the last login date for a user.
     *
     * @param userId the ID of the user
     * @param lastLogin the last login date
     */
    public void updateUserLastLogin(int userId, Date lastLogin){
        usersDao.updateUserLastLogin(userId, lastLogin);
    }
    
    /**
     * Updates an existing user.
     *
     * @param user the UserDTO representing the user to update
     */
    public void updateUser(UserDTO user){
        usersDao.updateUser(user);
    }
}
