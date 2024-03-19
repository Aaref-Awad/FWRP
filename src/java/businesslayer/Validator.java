/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

import DTO.UserDTO;

/**
 *
 * @author Owner
 */
public class Validator {
    private final static int USERNAME_LENGTH=25;
    private final static int PASSWORD_LENGTH=8;
    
    public static UserDTO validateUser(UserDTO user) throws ValidationException{
           Validator.validateUsername(user);
           Validator.validatePassword(user);
           return user;
    }
    /**
     * validation of username
     * @param user
     * @return
     * @throws ValidationException 
     */
    private static UserDTO validateUsername(UserDTO user) throws ValidationException{
        String username = user.getUsername();
        try{
            if (username.length() <= USERNAME_LENGTH && !username.equals(user.getUsername())){
             user = new UserDTO();
        }
        else{
            throw new ValidationException("Username is more than 25 characters");
        }
        }catch(ValidationException e){
            e.printStackTrace();
        }
        return user;
    }
    /**
     * validation of password
     * @param user
     * @return
     * @throws ValidationException 
     */
    private static UserDTO validatePassword(UserDTO user) throws ValidationException{
        String password = user.getPassword();
        try{
            if (password.length() <= PASSWORD_LENGTH){
             user = new UserDTO();
        }
        else{
            throw new ValidationException("Password is more than 25 characters");
        }
        }catch(ValidationException e){
            e.printStackTrace();
        }
        return user;
    }
}
