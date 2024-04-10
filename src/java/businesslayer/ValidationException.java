/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

/**
 * Represents an exception thrown when validation fails.
 * This exception is typically thrown when data is not in a valid format.
 * 
 * @author Tony Nsang
 */
public class ValidationException extends Exception {
    /**
     * Constructs a new ValidationException with a default message.
     */
    public ValidationException() {
       super("Data not in valid format");
   }

    /**
     * Constructs a new ValidationException with the specified detail message.
     * 
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method)
     */
   public ValidationException(String message) {
       super(message);
   }

    /**
     * Constructs a new ValidationException with the specified detail message and cause.
     * 
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method)
     * @param throwable the cause (which is saved for later retrieval by the Throwable.getCause() method)
     */
   public ValidationException(String message, Throwable throwable) {
       super(message, throwable);
   }

    /**
     * Constructs a new ValidationException with the specified cause and a detail message of (cause==null ? null : cause.toString()) (which typically contains the class and detail message of cause).
     * 
     * @param throwable the cause (which is saved for later retrieval by the Throwable.getCause() method)
     */
   public ValidationException(Throwable throwable) {
       super(throwable);
   }
}
