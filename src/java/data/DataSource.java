/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Manages database connection and provides a singleton instance.
 */
public class DataSource {

    private static Connection connection = null;
    private String driverString = "com.mysql.cj.jdbc.Driver";
    private static DataSource instance;
    
    /**
     * Constructs a DataSource object and initializes the database connection.
     */
    private DataSource() {
        try{
            Class.forName(this.driverString);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fwrp", "root", "TNT2004x@");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Driver class not found", e);
        }
    }
    
    /**
     * Retrieves the singleton instance of DataSource.
     *
     * @return The singleton instance of DataSource.
     */
    public static DataSource getInstance() {
        if (instance == null) {

            instance = new DataSource();
        }
        return instance;
    }

    /**
     * Retrieves the database connection.
     *
     * @return The database connection.
     */
    public Connection getConnection() {
    
        return connection;
    }
    
}

