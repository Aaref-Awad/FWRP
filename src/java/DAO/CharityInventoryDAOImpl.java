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
 * Retrieves all Charity Inventory records from the database.
 *
 * @return a list of all Charity Inventory records
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

    /**
     * Retrieves a Charity Inventory record from the database by its ID.
     *
     * @param inventoryId the ID of the Charity Inventory record to retrieve
     * @return the Charity Inventory record with the specified ID, or null if not found
     */
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

    /**
     * Retrieves all Charity Inventory records associated with a specific charity from the database.
     *
     * @param charityId the ID of the charity
     * @return a list of Charity Inventory records associated with the specified charity
     */
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

    /**
     * Inserts a new Charity Inventory record into the database.
     *
     * @param inventory the Charity Inventory record to insert
     */
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
    
    /**
     * Updates an existing Charity Inventory record in the database.
     *
     * @param inventory the Charity Inventory record to update
     */
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

    /**
     * Deletes a Charity Inventory record from the database.
     *
     * @param inventory the Charity Inventory record to delete
     */
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
    
    /**
     * Retrieves a list of Retailer Inventory records for items added after the last login date of a user.
     *
     * @param userId the ID of the user
     * @param lastLoginDate the date of the last login for the user
     * @return a list of Retailer Inventory records for items added after the last login date
     */
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
    
    /**
     * Checks if a given food name and retailer combination already exists in the database.
     *
     * @param foodName the name of the food
     * @param retailer the name of the retailer
     * @return true if the food name and retailer combination exists, false otherwise
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
     * Inserts a new retailer inventory record into the database.
     *
     * @param inventory the RetailerInventoryDTO object containing inventory details
     */
    public void insertRetailerInventory(RetailerInventoryDTO inventory) {
                try {
            pstmt = con.prepareStatement(
                    "INSERT INTO CharityInventory (CharityID, Quantity, FoodName, ExpirationDate, ItemAdded) "
                            + "VALUES(?, ?, ?, ?, ?)");
            pstmt.setInt(1, inventory.getUserID());
            pstmt.setInt(2, inventory.getFoodAmount());
            pstmt.setString(3, inventory.getFoodName());
            pstmt.setDate(4, new java.sql.Date(inventory.getExpirationDate().getTime()));
            pstmt.setTimestamp(5, new java.sql.Timestamp(System.currentTimeMillis())); // Use current timestamp for itemAdded
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Checks if a given food name and charity ID combination already exists in the database.
     *
     * @param foodName the name of the food
     * @param charityId the ID of the charity
     * @return true if the food name and charity ID combination exists, false otherwise
     */
    @Override
    public boolean isCharityFoodNameAndRetailerExists(String foodName, int charityId){
        boolean exists = false;
        try {
            pstmt = con.prepareStatement("SELECT COUNT(*) FROM CharityInventory WHERE FoodName = ? OR CharityID = ?");
            pstmt.setString(1, foodName);
            pstmt.setInt(2, charityId);
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