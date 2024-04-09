package DAO;

import DTO.FavoriteInventoryDTO;
import java.util.List;

public interface FavoriteInventoryDAO {
    // CRUD operations
    public List<FavoriteInventoryDTO> getAllFavorites();
    public FavoriteInventoryDTO getFavoriteById(int favoriteId);
    public List<FavoriteInventoryDTO> getFavoritesByUserId(int userId);
    public void insertFavorite(FavoriteInventoryDTO favorite);
    public void updateFavorite(FavoriteInventoryDTO favorite);
    public void deleteFavorite(FavoriteInventoryDTO favorite);
    public boolean isFavoriteAlreadyExists(int inventoryId, int userId);
    public void deleteFavoriteById(int favoriteId);
    public int getFavoriteIdByInventoryIdAndUserId(int inventoryId, int userId);
}
