package DAO;

import DTO.RetailerInventoryDTO;
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
                inventory.setFoodName(rs.getString("FoodName"));
                inventory.setFoodAmount(rs.getInt("FoodAmount"));
                inventory.setPrice(rs.getDouble("Price"));
                inventory.setExpirationDate(rs.getDate("ExpirationDate"));
                inventory.setSurplusType(rs.getString("SurplusType"));
              
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
                inventory.setFoodName(rs.getString("FoodName"));
                inventory.setFoodAmount(rs.getInt("FoodAmount"));
                inventory.setPrice(rs.getDouble("Price"));
                inventory.setExpirationDate(rs.getDate("ExpirationDate"));
                inventory.setSurplusType(rs.getString("SurplusType"));
                
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
                    "INSERT INTO RetailerInventory (UserID, FoodAmount, FoodName, Price, ExpirationDate, SurplusType) "
                    + "VALUES( ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, inventory.getUserID());
            pstmt.setInt(2, inventory.getFoodAmount());
            pstmt.setString(3, inventory.getFoodName());
            pstmt.setDouble(4, inventory.getPrice());
            pstmt.setDate(5, new java.sql.Date(inventory.getExpirationDate().getTime()));
            pstmt.setString(6, inventory.getSurplusType());
            pstmt.executeUpdate();
              
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInventory(RetailerInventoryDTO inventory) {      
        try {
            
            pstmt = con.prepareStatement(
                    "UPDATE RetailerInventory SET UserID=?, FoodAmount=?, Price=?, ExpirationDate=?, SurplusType=? WHERE InventoryID=?");
            pstmt.setInt(1, inventory.getUserID());
            pstmt.setInt(2, inventory.getFoodAmount());
            pstmt.setDouble(3, inventory.getPrice());
            pstmt.setDate(4, new java.sql.Date(inventory.getExpirationDate().getTime()));
            pstmt.setString(5, inventory.getSurplusType());
            pstmt.setInt(6, inventory.getInventoryID());
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
}