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
 * The DataSource class provides methods to establish a connection to the database.
 * It implements the Singleton pattern to ensure only one instance of the connection is created.
 * 
 * This class uses JDBC to connect to the MySQL database.
 * 
 * @author Owner
 */
public class DataSource {

    private static Connection connection = null;
    private String driverString = "com.mysql.cj.jdbc.Driver";
    private static DataSource instance;
    
    /**
     * Private constructor to prevent external instantiation.
     * Initializes the database connection.
     */
    private DataSource() {
        try {
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
     * Returns the singleton instance of the DataSource.
     * 
     * @return the DataSource instance
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
     * @return the database connection
     */
    public Connection getConnection() {
        return connection;
    }
}
