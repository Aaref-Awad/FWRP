package DAO;

import DTO.RetailerInventoryDTO;
import data.DataSource;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp; 
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 *
 * Implementation of RetailerInventoryDAO
 */
public class RetailerInventoryDAOImpl implements RetailerInventoryDAO {

    private static Connection con = DataSource.getInstance().getConnection();
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    /**
     * Retrieves all retailer inventory items from the database.
     *
     * @return A list of all retailer inventory items.
     */
    @Override
    public List<RetailerInventoryDTO> getAllInventories() {
        ArrayList<RetailerInventoryDTO> inventories = null;

        try {
            String query = "SELECT * FROM RetailerInventory r ORDER BY r.InventoryID";
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery();
            inventories = new ArrayList<>();
            while (rs.next()) {
                RetailerInventoryDTO inventory = new RetailerInventoryDTO();
                inventory.setInventoryID(rs.getInt("InventoryID"));
                inventory.setUserID(rs.getInt("UserID"));
                inventory.setFoodName(rs.getString("FoodName"));
                inventory.setFoodAmount(rs.getInt("FoodAmount"));
                inventory.setPrice(rs.getDouble("Price"));
                inventory.setExpirationDate(rs.getDate("ExpirationDate"));
                inventory.setSurplusType(rs.getString("SurplusType"));
                inventory.setItemAdded(rs.getTimestamp("ItemAdded")); // Include ItemAdded

                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventories;
    }

    /**
     * Retrieves a retailer inventory item from the database by its ID.
     *
     * @param inventoryId The ID of the inventory item to retrieve.
     * @return The retailer inventory item with the specified ID, or null if not found.
     */
    @Override
    public RetailerInventoryDTO getInventoryById(int inventoryId) {
        RetailerInventoryDTO inventory = null;

        try {
            pstmt = con.prepareStatement(
                    "SELECT * FROM RetailerInventory r WHERE r.InventoryID = ?");
            pstmt.setInt(1, inventoryId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                inventory = new RetailerInventoryDTO();
                inventory.setUserID(rs.getInt("UserID"));
                inventory.setInventoryID(inventoryId);
                inventory.setFoodName(rs.getString("FoodName"));
                inventory.setFoodAmount(rs.getInt("FoodAmount"));
                inventory.setPrice(rs.getDouble("Price"));
                inventory.setExpirationDate(rs.getDate("ExpirationDate"));
                inventory.setSurplusType(rs.getString("SurplusType"));
                inventory.setItemAdded(rs.getTimestamp("ItemAdded")); // Include ItemAdded
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return inventory;
    }

    /**
    * Retrieves all retailer inventory items for a specific user from the database.
    *
    * @param userId The ID of the user.
    * @return A list of all retailer inventory items for the specified user.
    */
    @Override
    public List<RetailerInventoryDTO> getInventoriesByUserId(int userId) {
        ArrayList<RetailerInventoryDTO> inventories = null;
        try {
            pstmt = con.prepareStatement(
                    "SELECT * FROM RetailerInventory WHERE UserID = ?");
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            inventories = new ArrayList<>();
            while (rs.next()) {
                RetailerInventoryDTO inventory = new RetailerInventoryDTO();
                inventory.setInventoryID(rs.getInt("InventoryID"));
                inventory.setUserID(rs.getInt("UserID"));
                inventory.setFoodAmount(rs.getInt("FoodAmount"));
                inventory.setFoodName(rs.getString("FoodName"));
                inventory.setPrice(rs.getDouble("Price"));
                inventory.setExpirationDate(rs.getDate("ExpirationDate"));
                inventory.setSurplusType(rs.getString("SurplusType"));
                inventory.setItemAdded(rs.getTimestamp("ItemAdded")); // Include ItemAdded
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return inventories;
    }


    /**
    * Inserts a new retailer inventory item into the database.
    *
    * @param inventory The retailer inventory item to insert.
    */
    @Override
    public void insertInventory(RetailerInventoryDTO inventory) {
        try {
            pstmt = con.prepareStatement(
                    "INSERT INTO RetailerInventory (UserID, FoodAmount, FoodName, Price, ExpirationDate, SurplusType, ItemAdded) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, inventory.getUserID());
            pstmt.setInt(2, inventory.getFoodAmount());
            pstmt.setString(3, inventory.getFoodName());
            pstmt.setDouble(4, inventory.getPrice());
            pstmt.setDate(5, new java.sql.Date(inventory.getExpirationDate().getTime()));
            pstmt.setString(6, inventory.getSurplusType());
            pstmt.setTimestamp(7, new java.sql.Timestamp(System.currentTimeMillis())); // Use current timestamp for ItemAdded
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
    * Updates an existing retailer inventory item in the database.
    *
    * @param inventory The retailer inventory item to update.
    */
    @Override
    public void updateInventory(RetailerInventoryDTO inventory) {
        try {
            pstmt = con.prepareStatement(
                    "UPDATE RetailerInventory SET UserID=?, FoodAmount=?, FoodName=?, Price=?, ExpirationDate=?, SurplusType=?, ItemAdded=? WHERE InventoryID=?");
            pstmt.setInt(1, inventory.getUserID());
            pstmt.setInt(2, inventory.getFoodAmount());
            pstmt.setString(3, inventory.getFoodName());
            pstmt.setDouble(4, inventory.getPrice());
            pstmt.setDate(5, new java.sql.Date(inventory.getExpirationDate().getTime()));
            pstmt.setString(6, inventory.getSurplusType());
            pstmt.setTimestamp(7, new java.sql.Timestamp(System.currentTimeMillis())); // Use current timestamp for ItemAdded
            pstmt.setInt(8, inventory.getInventoryID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
    * Deletes a retailer inventory item from the database.
    *
    * @param inventory The retailer inventory item to delete.
    */
    @Override
    public void deleteInventory(RetailerInventoryDTO inventory) {
        try {
            pstmt = con.prepareStatement(
                    "DELETE FROM RetailerInventory WHERE InventoryID = ?");
            pstmt.setInt(1, inventory.getInventoryID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }

    /**
    * Checks if a food item with the given name already exists in the database.
    *
    * @param foodName The name of the food item to check.
    * @return true if the food item already exists, false otherwise.
    */
    @Override
    public boolean isFoodNameAlreadyExists(String foodName) {
        boolean exists = false;
        try {
            pstmt = con.prepareStatement("SELECT COUNT(*) FROM RetailerInventory WHERE FoodName = ?");
            pstmt.setString(1, foodName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                exists = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
        
    /**
    * Updates the amount of food in a retailer inventory item in the database.
    *
    * @param inventory The retailer inventory item to update.
    */
    @Override
    public void updateInventoryFoodAmount(RetailerInventoryDTO inventory) {
        try {
            pstmt = con.prepareStatement(
                    "UPDATE RetailerInventory SET FoodAmount=? WHERE InventoryID=?");
            pstmt.setInt(1, inventory.getFoodAmount());
            pstmt.setInt(2, inventory.getInventoryID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
    * Retrieves a list of retailer inventory items that were added after the user's last login date.
    *
    * @param userId The ID of the user.
    * @param lastLoginDate The date of the user's last login.
    * @return A list of retailer inventory items added after the last login date.
    */
    @Override
    public List<RetailerInventoryDTO> getNewlyAddedItems(int userId, Date lastLoginDate) {
        List<RetailerInventoryDTO> newlyAddedItems = new ArrayList<>();
           PreparedStatement pstmt = null;
           ResultSet rs = null;

           try {
               // SQL query to select items added after the last login date
               String query = "SELECT * FROM RetailerInventory WHERE ItemAdded > ?";

               pstmt = con.prepareStatement(query);
               pstmt.setTimestamp(1, new Timestamp(lastLoginDate.getTime()));
               rs = pstmt.executeQuery();

               // Iterate through the result set and create RetailerInventoryDTO objects
               while (rs.next()) {
                   RetailerInventoryDTO inventory = new RetailerInventoryDTO();
                   inventory.setInventoryID(rs.getInt("InventoryID"));
                   inventory.setUserID(rs.getInt("UserID"));
                   inventory.setFoodAmount(rs.getInt("FoodAmount"));
                   inventory.setFoodName(rs.getString("FoodName"));
                   inventory.setPrice(rs.getDouble("Price"));
                   inventory.setExpirationDate(rs.getDate("ExpirationDate"));
                   inventory.setSurplusType(rs.getString("SurplusType"));
                   inventory.setItemAdded(rs.getTimestamp("ItemAdded"));
                   newlyAddedItems.add(inventory);
               }
           } catch (SQLException e) {
               e.printStackTrace();
           } finally {
               // Close PreparedStatement and ResultSet
               if (rs != null) {
                   try {
                       rs.close();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }
               if (pstmt != null) {
                   try {
                       pstmt.close();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               }
           }

           return newlyAddedItems;
       }
    
    /**
    * Checks if a food item with the given name or a retailer with the given name already exists in the database.
    *
    * @param foodName The name of the food item to check.
    * @param retailer The name of the retailer to check.
    * @return true if the food item or retailer already exists, false otherwise.
    */
    @Override
    public boolean isFoodNameAndRetailerExists(String foodName, String retailer){
        boolean exists = false;
        try {
            pstmt = con.prepareStatement("SELECT COUNT(*) FROM FavoriteInventory WHERE FoodName = ? OR RetailerName = ?");
            pstmt.setString(1, foodName);
            pstmt.setString(2, retailer);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                exists = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
    
    /**
    * Checks if a retailer inventory item is near expiration date or if the amount is over 50.
    *
    * @param inventory The retailer inventory item to check.
    * @return true if the item is near expiration date or if the amount is over 50, false otherwise.
    */
    @Override
    public boolean isSurPlus(RetailerInventoryDTO inventory) {
        // Convert the expiration date to LocalDate
        LocalDate currentDate = LocalDate.now();
        LocalDate expirationDate = 
            Instant.ofEpochMilli(inventory.getExpirationDate().getTime())
                   .atZone(ZoneId.systemDefault())
                   .toLocalDate();

        // Calculate the difference in days between the current date and the expiration date
        long daysUntilExpiration = ChronoUnit.DAYS.between(currentDate, expirationDate);

        // Check if the item is near expiration date by 1 week or if the amount is over 50
        return daysUntilExpiration <= 7 || inventory.getFoodAmount() > 50;
    }
    
    /**
    * Checks if a user can buy an item based on their balance.
    *
    * @param userId The ID of the user.
    * @param itemPrice The price of the item.
    * @return true if the user can buy the item, false otherwise.
    */
    @Override
    public boolean canUserBuyItem(int userId, double itemPrice) {
        boolean canBuy = false;
        try {
            // Retrieve the user's balance from the database
            pstmt = con.prepareStatement("SELECT Balance FROM User WHERE UserID = ?");
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();

            // Check if the user exists and has enough balance to buy the item
            if (rs.next()) {
                double userBalance = rs.getDouble("Balance");
                if (userBalance >= itemPrice) {
                    canBuy = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return canBuy;
    }



}

