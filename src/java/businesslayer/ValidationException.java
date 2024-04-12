/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;

/**
 * Exception thrown when data does not meet validation criteria.
 */
public class ValidationException extends Exception {
    /**
     * Constructs a ValidationException with the default message "Data not in valid format".
     */
    public ValidationException() {
       super("Data not in valid format");
   }

    /**
     * Constructs a ValidationException with the specified message.
     *
     * @param message The detail message.
     */
   public ValidationException(String message) {
       super(message);
   }

    /**
     * Constructs a ValidationException with the specified message and cause.
     *
     * @param message The detail message.
     * @param throwable The cause.
     */
   public ValidationException(String message, Throwable throwable) {
       super(message, throwable);
   }

    /**
     * Constructs a ValidationException with the specified cause.
     *
     * @param throwable The cause.
     */
   public ValidationException(Throwable throwable) {
       super(throwable);
   }
}

