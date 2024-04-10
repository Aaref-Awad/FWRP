package DAO;

import DTO.CharityInventoryDTO;
import DTO.RetailerInventoryDTO;
import data.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implementation of CharityInventoryDAO
 */
public class CharityInventoryDAOImpl implements CharityInventoryDAO {

    private static Connection con = DataSource.getInstance().getConnection();
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    @Override
    public List<CharityInventoryDTO> getAllInventories() {
        ArrayList<CharityInventoryDTO> inventories = null;

        try {
            String query = "SELECT * FROM CharityInventory ORDER BY InventoryID";
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery();
            inventories = new ArrayList<>();
            while (rs.next()) {
                CharityInventoryDTO inventory = new CharityInventoryDTO();
                inventory.setInventoryID(rs.getInt("InventoryID"));
                inventory.setCharityID(rs.getInt("CharityID"));
                inventory.setQuantity(rs.getInt("Quantity"));
                inventory.setFoodName(rs.getString("FoodName"));
                inventory.setExpirationDate(rs.getDate("ExpirationDate"));
                inventory.setItemAdded(rs.getTimestamp("ItemAdded")); // Set the itemAdded attribute
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventories;
    }

    @Override
    public CharityInventoryDTO getInventoryById(int inventoryId) {
        CharityInventoryDTO inventory = null;

        try {
            pstmt = con.prepareStatement(
                    "SELECT * FROM CharityInventory WHERE InventoryID = ?");
            pstmt.setInt(1, inventoryId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                inventory = new CharityInventoryDTO();
                inventory.setInventoryID(rs.getInt("InventoryID"));
                inventory.setCharityID(rs.getInt("CharityID"));
                inventory.setQuantity(rs.getInt("Quantity"));
                inventory.setFoodName(rs.getString("FoodName"));
                inventory.setExpirationDate(rs.getDate("ExpirationDate"));
                inventory.setItemAdded(rs.getTimestamp("ItemAdded")); // Set the itemAdded attribute
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventory;
    }

    @Override
    public List<CharityInventoryDTO> getInventoriesByCharityId(int charityId) {
        ArrayList<CharityInventoryDTO> inventories = null;
        try {
            pstmt = con.prepareStatement(
                    "SELECT * FROM CharityInventory WHERE CharityID = ?");
            pstmt.setInt(1, charityId);
            rs = pstmt.executeQuery();
            inventories = new ArrayList<>();
            while (rs.next()) {
                CharityInventoryDTO inventory = new CharityInventoryDTO();
                inventory.setInventoryID(rs.getInt("InventoryID"));
                inventory.setCharityID(rs.getInt("CharityID"));
                inventory.setQuantity(rs.getInt("Quantity"));
                inventory.setFoodName(rs.getString("FoodName"));
                inventory.setExpirationDate(rs.getDate("ExpirationDate"));
                inventory.setItemAdded(rs.getTimestamp("ItemAdded")); // Set the itemAdded attribute
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventories;
    }

    @Override
    public void insertInventory(CharityInventoryDTO inventory) {
        try {
            pstmt = con.prepareStatement(
                    "INSERT INTO CharityInventory (CharityID, Quantity, FoodName, ExpirationDate, ItemAdded) "
                            + "VALUES(?, ?, ?, ?, ?)");
            pstmt.setInt(1, inventory.getCharityID());
            pstmt.setInt(2, inventory.getQuantity());
            pstmt.setString(3, inventory.getFoodName());
            pstmt.setDate(4, new java.sql.Date(inventory.getExpirationDate().getTime()));
            pstmt.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis())); // Use current timestamp for itemAdded
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInventory(CharityInventoryDTO inventory) {
        try {
            pstmt = con.prepareStatement(
                    "UPDATE CharityInventory SET CharityID=?, Quantity=?, FoodName=?, ExpirationDate=?, ItemAdded=? WHERE InventoryID=?");
            pstmt.setInt(1, inventory.getCharityID());
            pstmt.setInt(2, inventory.getQuantity());
            pstmt.setString(3, inventory.getFoodName());
            pstmt.setDate(4, new java.sql.Date(inventory.getExpirationDate().getTime()));
            pstmt.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis())); // Use current timestamp for itemAdded
            pstmt.setInt(6, inventory.getInventoryID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteInventory(CharityInventoryDTO inventory) {
        try {
            pstmt = con.prepareStatement("DELETE FROM CharityInventory WHERE InventoryID = ?");
            pstmt.setInt(1, inventory.getInventoryID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public List<RetailerInventoryDTO> getNewlyAddedItems(int userId, Date lastLoginDate) {
        List<RetailerInventoryDTO> newlyAddedItems = new ArrayList<>();
           PreparedStatement pstmt = null;
           ResultSet rs = null;

           try {
               // SQL query to select items added after the last login date
               String query = "SELECT * FROM CharityInventory WHERE ItemAdded > ?";

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
}