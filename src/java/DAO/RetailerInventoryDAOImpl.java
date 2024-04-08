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

/**
 *
 * Implementation of RetailerInventoryDAO
 */
public class RetailerInventoryDAOImpl implements RetailerInventoryDAO {

    private static Connection con = DataSource.getInstance().getConnection();
    private static PreparedStatement pstmt;
    private static ResultSet rs;

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
}

