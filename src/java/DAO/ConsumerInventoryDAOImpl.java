package DAO;

import DTO.ConsumerInventoryDTO;
import data.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aaref
 */
public class ConsumerInventoryDAOImpl implements ConsumerInventoryDAO {
    
    private static Connection con = DataSource.getInstance().getConnection();
    private static PreparedStatement pstmt;
    private static ResultSet rs;
	
    @Override
    public List<ConsumerInventoryDTO> getAllInventories() {
      
        ArrayList<ConsumerInventoryDTO> inventories = null;

        try {
            String query = "SELECT * FROM ConsumerInventory ORDER BY InventoryID";
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery();
            inventories = new ArrayList<>();
            while (rs.next()) {
                ConsumerInventoryDTO inventory = new ConsumerInventoryDTO();
                inventory.setInventoryID(rs.getInt("InventoryID"));
                inventory.setConsumerID(rs.getInt("ConsumerID"));
                inventory.setFoodID(rs.getInt("FoodID"));
                inventory.setQuantity(rs.getInt("Quantity"));
              
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return inventories;
    }

    @Override
    public ConsumerInventoryDTO getInventoryById(int inventoryId) {
       
        ConsumerInventoryDTO inventory = null;

        try {
            
            pstmt = con.prepareStatement(
                    "SELECT * FROM ConsumerInventory WHERE InventoryID = ?");
            pstmt.setInt(1, inventoryId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                inventory = new ConsumerInventoryDTO();
                inventory.setConsumerID(rs.getInt("ConsumerID"));
                inventory.setFoodID(rs.getInt("FoodID"));
                inventory.setQuantity(rs.getInt("Quantity"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return inventory;
    }
    
    @Override
    public List<ConsumerInventoryDTO> getInventoriesByConsumerId(int consumerId) {
        ArrayList<ConsumerInventoryDTO> inventories = null;
        try {
            pstmt = con.prepareStatement(
                    "SELECT * FROM ConsumerInventory WHERE ConsumerID = ?");
            pstmt.setInt(1, consumerId);
            rs = pstmt.executeQuery();
            inventories = new ArrayList<>();
            while (rs.next()) {
                ConsumerInventoryDTO inventory = new ConsumerInventoryDTO();
                inventory.setInventoryID(rs.getInt("InventoryID"));
                inventory.setConsumerID(rs.getInt("ConsumerID"));
                inventory.setFoodID(rs.getInt("FoodID"));
                inventory.setQuantity(rs.getInt("Quantity"));
                
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return inventories;
    }


    @Override
    public void insertInventory(ConsumerInventoryDTO inventory) {
        try {
            pstmt = con.prepareStatement(
                    "INSERT INTO ConsumerInventory (ConsumerID, FoodID, Quantity) "
                    + "VALUES( ?, ?, ?)");
            pstmt.setInt(1, inventory.getConsumerID());
            pstmt.setInt(2, inventory.getFoodID());
            pstmt.setInt(3, inventory.getQuantity());
            pstmt.executeUpdate();
              
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInventory(ConsumerInventoryDTO inventory) {      
        try {
            
            pstmt = con.prepareStatement(
                    "UPDATE ConsumerInventory SET ConsumerID=?, FoodID=?, Quantity=? WHERE InventoryID=?");
            pstmt.setInt(1, inventory.getConsumerID());
            pstmt.setInt(2, inventory.getFoodID());
            pstmt.setInt(3, inventory.getQuantity());
            pstmt.setInt(4, inventory.getInventoryID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteInventory(ConsumerInventoryDTO inventory) {
        try {
            
            pstmt = con.prepareStatement(
                    "DELETE FROM ConsumerInventory WHERE InventoryID = ?");
            pstmt.setInt(1, inventory.getInventoryID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
