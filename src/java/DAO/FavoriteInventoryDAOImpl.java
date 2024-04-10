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
 * Implementation of FavoriteInventoryDAO interface providing methods to interact with favorite inventory data in the database.
 */
public class FavoriteInventoryDAOImpl implements FavoriteInventoryDAO {

    private static Connection con = DataSource.getInstance().getConnection();
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    /**
     * Retrieves all favorite inventory entries from the database.
     *
     * @return a list of FavoriteInventoryDTO objects representing all favorite inventory entries
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
     * Retrieves a favorite inventory entry from the database by its ID.
     *
     * @param favoriteId the ID of the favorite inventory entry to retrieve
     * @return the FavoriteInventoryDTO object representing the favorite inventory entry with the specified ID
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
     * Retrieves all favorite inventory entries associated with a specific user from the database.
     *
     * @param userId the ID of the user
     * @return a list of FavoriteInventoryDTO objects representing the favorite inventory entries associated with the user
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
     * Inserts a new favorite inventory entry into the database.
     *
     * @param favorite the FavoriteInventoryDTO object representing the favorite inventory entry to be inserted
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
     * Updates an existing favorite inventory entry in the database.
     *
     * @param favorite the FavoriteInventoryDTO object representing the favorite inventory entry to be updated
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
     * Deletes a favorite inventory entry from the database.
     *
     * @param favorite the FavoriteInventoryDTO object representing the favorite inventory entry to be deleted
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
     * Checks if a favorite inventory entry already exists in the database.
     *
     * @param inventoryId the ID of the inventory
     * @param userId      the ID of the user
     * @return true if the favorite inventory entry exists, false otherwise
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
     * Deletes a favorite inventory entry from the database by its ID.
     *
     * @param favoriteId the ID of the favorite inventory entry to be deleted
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
     * Retrieves the ID of the favorite inventory entry by its associated inventory and user.
     *
     * @param inventoryId the ID of the inventory
     * @param userId      the ID of the user
     * @return the ID of the favorite inventory entry, or -1 if not found
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
