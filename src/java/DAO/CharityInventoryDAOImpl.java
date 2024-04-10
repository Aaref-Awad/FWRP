package DAO;

import DTO.CharityInventoryDTO;
import data.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of CharityInventoryDAO
 */
public class CharityInventoryDAOImpl implements CharityInventoryDAO {

    private static Connection con = DataSource.getInstance().getConnection();
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    /**
     * Retrieves all inventories from the database.
     *
     * @return a list of CharityInventoryDTO objects representing all inventories
     */
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
     * Retrieves an inventory from the database by its ID.
     *
     * @param inventoryId the ID of the inventory to retrieve
     * @return the CharityInventoryDTO object representing the inventory with the specified ID
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
     * Retrieves all inventories associated with a specific charity from the database.
     *
     * @param charityId the ID of the charity
     * @return a list of CharityInventoryDTO objects representing the inventories associated with the charity
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
     * Inserts an inventory into the database.
     *
     * @param inventory the CharityInventoryDTO object representing the inventory to be inserted
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
     * Updates an inventory in the database.
     *
     * @param inventory the CharityInventoryDTO object representing the inventory to be updated
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
     * Deletes an inventory from the database.
     *
     * @param inventory the CharityInventoryDTO object representing the inventory to be deleted
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
}
