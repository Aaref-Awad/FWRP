package DAO;

import DTO.FavoriteInventoryDTO;
import data.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteInventoryDAOImpl implements FavoriteInventoryDAO {

    private static Connection con = DataSource.getInstance().getConnection();
    private static PreparedStatement pstmt;
    private static ResultSet rs;

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
