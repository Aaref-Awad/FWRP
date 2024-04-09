package businesslayer;

import DAO.FavoriteInventoryDAOImpl;
import DTO.FavoriteInventoryDTO;
import java.util.List;

public class FavoriteInventoryBusinessLogic {
    private FavoriteInventoryDAOImpl favoriteInventoryDao = null;

    public FavoriteInventoryBusinessLogic() {
        favoriteInventoryDao = new FavoriteInventoryDAOImpl();
    }

    public List<FavoriteInventoryDTO> getAllFavorites() {
        return favoriteInventoryDao.getAllFavorites();
    }

    public List<FavoriteInventoryDTO> getFavoritesByUserId(int userId) {
        return favoriteInventoryDao.getFavoritesByUserId(userId);
    }

    public FavoriteInventoryDTO getFavoriteById(int favoriteId) {
        return favoriteInventoryDao.getFavoriteById(favoriteId);
    }

    public void addFavorite(FavoriteInventoryDTO favorite) {
        favoriteInventoryDao.insertFavorite(favorite);
    }

    public void deleteFavorite(int favoriteId) {
        favoriteInventoryDao.deleteFavoriteById(favoriteId);
    }
    
    public boolean isFavorite(int inventoryId, int userId){
        return favoriteInventoryDao.isFavoriteAlreadyExists(inventoryId, userId);
    }

    public int getFavoriteIdByInventoryIdAndUserId(int inventoryId, int userId) {
        return favoriteInventoryDao.getFavoriteIdByInventoryIdAndUserId(inventoryId, userId);
    }
}
