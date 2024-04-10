/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import DTO.UserDTO;

/**
 * The Validator class provides methods for validating user data.
 * This class includes methods to validate usernames and passwords.
 * 
 * @author Owner
 */
public class Validator {
    private final static int USERNAME_LENGTH = 25;
    private final static int PASSWORD_LENGTH = 8;
    
    /**
     * Validates the user data.
     * 
     * @param user the UserDTO object to validate
     * @return the validated UserDTO object
     * @throws ValidationException if validation fails
     */
    public static UserDTO validateUser(UserDTO user) throws ValidationException {
        Validator.validateUsername(user);
        Validator.validatePassword(user);
        return user;
    }
    
    /**
     * Validates the username.
     * 
     * @param user the UserDTO object containing the username to validate
     * @return the validated UserDTO object
     * @throws ValidationException if the username is invalid
     */
    private static UserDTO validateUsername(UserDTO user) throws ValidationException {
        String username = user.getUsername();
        try {
            if (username.length() <= USERNAME_LENGTH && !username.equals(user.getUsername())) {
                user = new UserDTO();
            } else {
                throw new ValidationException("Username is more than 25 characters");
            }
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    /**
     * Validates the password.
     * 
     * @param user the UserDTO object containing the password to validate
     * @return the validated UserDTO object
     * @throws ValidationException if the password is invalid
     */
    private static UserDTO validatePassword(UserDTO user) throws ValidationException {
        String password = user.getPassword();
        try {
            if (password.length() <= PASSWORD_LENGTH) {
                user = new UserDTO();
            } else {
                throw new ValidationException("Password is more than 25 characters");
            }
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        return user;
    }
}
