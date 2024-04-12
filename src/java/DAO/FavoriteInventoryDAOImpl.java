package DAO;

import DTO.FavoriteInventoryDTO;
import data.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the FavoriteInventoryDAO interface for managing favorite inventory items in a database.
 */
public class FavoriteInventoryDAOImpl implements FavoriteInventoryDAO {

    private static Connection con = DataSource.getInstance().getConnection();
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    /**
     * Retrieves all favorite inventory items from the database.
     *
     * @return A list of all favorite inventory items.
     */
    @Override
    public List<FavoriteInventoryDTO> getAllFavorites() {
        ArrayList<FavoriteInventoryDTO> favorites = null;

        try {
            String query = "SELECT * FROM FavoriteInventory";
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery();
            favorites = new ArrayList<>();
            while (rs.next()) {
                FavoriteInventoryDTO favorite = new FavoriteInventoryDTO();
                favorite.setFavoriteID(rs.getInt("FavoriteID"));
                favorite.setUserID(rs.getInt("UserID"));
                favorite.setInventoryID(rs.getInt("InventoryID")); // Updated
                favorite.setFoodName(rs.getString("FoodName"));
                favorite.setRetailerName(rs.getString("RetailerName"));

                favorites.add(favorite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favorites;
    }

    /**
     * Retrieves a favorite inventory item from the database by its ID.
     *
     * @param favoriteId The ID of the favorite inventory item to retrieve.
     * @return The favorite inventory item with the specified ID, or null if not found.
     */
    @Override
    public FavoriteInventoryDTO getFavoriteById(int favoriteId) {
        FavoriteInventoryDTO favorite = null;

        try {
            pstmt = con.prepareStatement(
                    "SELECT * FROM FavoriteInventory WHERE FavoriteID = ?");
            pstmt.setInt(1, favoriteId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                favorite = new FavoriteInventoryDTO();
                favorite.setFavoriteID(favoriteId);
                favorite.setUserID(rs.getInt("UserID"));
                favorite.setInventoryID(rs.getInt("InventoryID")); // Updated
                favorite.setFoodName(rs.getString("FoodName"));
                favorite.setRetailerName(rs.getString("RetailerName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favorite;
    }

    /**
     * Retrieves all favorite inventory items for a specific user from the database.
     *
     * @param userId The ID of the user.
     * @return A list of all favorite inventory items for the specified user.
     */
    @Override
    public List<FavoriteInventoryDTO> getFavoritesByUserId(int userId) {
        ArrayList<FavoriteInventoryDTO> favorites = null;
        try {
            pstmt = con.prepareStatement(
                    "SELECT * FROM FavoriteInventory WHERE UserID = ?");
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            favorites = new ArrayList<>();
            while (rs.next()) {
                FavoriteInventoryDTO favorite = new FavoriteInventoryDTO();
                favorite.setFavoriteID(rs.getInt("FavoriteID"));
                favorite.setUserID(userId);
                favorite.setInventoryID(rs.getInt("InventoryID")); // Updated
                favorite.setFoodName(rs.getString("FoodName"));
                favorite.setRetailerName(rs.getString("RetailerName"));
                favorites.add(favorite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favorites;
    }

    /**
     * Inserts a new favorite inventory item into the database.
     *
     * @param favorite The favorite inventory item to insert.
     */
    @Override
    public void insertFavorite(FavoriteInventoryDTO favorite) {
        try {
            pstmt = con.prepareStatement(
                    "INSERT INTO FavoriteInventory (UserID, InventoryID, FoodName, RetailerName) VALUES (?, ?, ?, ?)");
            pstmt.setInt(1, favorite.getUserID());
            pstmt.setInt(2, favorite.getInventoryID());
            pstmt.setString(3, favorite.getFoodName());
            pstmt.setString(4, favorite.getRetailerName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing favorite inventory item in the database.
     *
     * @param favorite The favorite inventory item to update.
     */
    @Override
    public void updateFavorite(FavoriteInventoryDTO favorite) {
        try {
            pstmt = con.prepareStatement(
                    "UPDATE FavoriteInventory SET UserID = ?, InventoryID = ?, FoodName = ?, RetailerName = ? WHERE FavoriteID = ?");
            pstmt.setInt(1, favorite.getUserID());
            pstmt.setInt(2, favorite.getInventoryID());
            pstmt.setString(3, favorite.getFoodName());
            pstmt.setString(4, favorite.getRetailerName());
            pstmt.setInt(5, favorite.getFavoriteID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a favorite inventory item from the database.
     *
     * @param favorite The favorite inventory item to delete.
     */
    @Override
    public void deleteFavorite(FavoriteInventoryDTO favorite) {
        try {
            pstmt = con.prepareStatement(
                    "DELETE FROM FavoriteInventory WHERE FavoriteID = ?");
            pstmt.setInt(1, favorite.getFavoriteID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if a favorite inventory item already exists in the database.
     *
     * @param inventoryId The ID of the inventory item.
     * @param userId      The ID of the user.
     * @return true if the favorite inventory item already exists, false otherwise.
     */
    @Override
    public boolean isFavoriteAlreadyExists(int inventoryId, int userId) {
        try {
            pstmt = con.prepareStatement(
                    "SELECT COUNT(*) AS count FROM FavoriteInventory WHERE InventoryID = ? AND UserID = ?");
            pstmt.setInt(1, inventoryId);
            pstmt.setInt(2, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
    * Deletes a favorite inventory item from the database by its ID.
    *
    * @param favoriteId The ID of the favorite inventory item to delete.
    */
    @Override
    public void deleteFavoriteById(int favoriteId) {
        try {
            pstmt = con.prepareStatement(
                    "DELETE FROM FavoriteInventory WHERE FavoriteID = ?");
            pstmt.setInt(1, favoriteId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
 * Retrieves the ID of a favorite inventory item from the database by inventory ID and user ID.
 *
 * @param inventoryId The ID of the inventory item.
 * @param userId      The ID of the user.
 * @return The ID of the favorite inventory item, or -1 if not found.
 */
    @Override
    public int getFavoriteIdByInventoryIdAndUserId(int inventoryId, int userId) {
        int favoriteId = -1; // Default value if no favorite found

        try {
            pstmt = con.prepareStatement(
                    "SELECT FavoriteID FROM FavoriteInventory WHERE InventoryID = ? AND UserID = ?");
            pstmt.setInt(1, inventoryId);
            pstmt.setInt(2, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                favoriteId = rs.getInt("FavoriteID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return favoriteId;
    }


}
