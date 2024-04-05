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
 *
 * @author Aaref
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
    public CharityInventoryDTO getInventoryById(int inventoryId) {
       
        CharityInventoryDTO inventory = null;

        try {
            
            pstmt = con.prepareStatement(
                    "SELECT * FROM CharityInventory WHERE InventoryID = ?");
            pstmt.setInt(1, inventoryId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                inventory = new CharityInventoryDTO();
                inventory.setCharityID(rs.getInt("CharityID"));
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
    public void insertInventory(CharityInventoryDTO inventory) {
        try {
            pstmt = con.prepareStatement(
                    "INSERT INTO CharityInventory (CharityID, FoodID, Quantity) "
                    + "VALUES( ?, ?, ?)");
            pstmt.setInt(1, inventory.getCharityID());
            pstmt.setInt(2, inventory.getFoodID());
            pstmt.setInt(3, inventory.getQuantity());
            pstmt.executeUpdate();
              
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInventory(CharityInventoryDTO inventory) {      
        try {
            
            pstmt = con.prepareStatement(
                    "UPDATE CharityInventory SET CharityID=?, FoodID=?, Quantity=? WHERE InventoryID=?");
            pstmt.setInt(1, inventory.getCharityID());
            pstmt.setInt(2, inventory.getFoodID());
            pstmt.setInt(3, inventory.getQuantity());
            pstmt.setInt(4, inventory.getInventoryID());
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
}
