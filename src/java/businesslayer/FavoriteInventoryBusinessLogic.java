package businesslayer;

import DAO.FavoriteInventoryDAOImpl;
import DTO.FavoriteInventoryDTO;
import java.util.List;

/**
 * Handles business logic related to favorite inventory management.
 */
public class FavoriteInventoryBusinessLogic {
    private FavoriteInventoryDAOImpl favoriteInventoryDao = null;

    /**
     * Constructs a FavoriteInventoryBusinessLogic object and initializes the DAO.
     */
    public FavoriteInventoryBusinessLogic() {
        favoriteInventoryDao = new FavoriteInventoryDAOImpl();
    }

    /**
     * Retrieves all favorite inventory items from the database.
     *
     * @return A list of all favorite inventory items.
     */
    public List<FavoriteInventoryDTO> getAllFavorites() {
        return favoriteInventoryDao.getAllFavorites();
    }

    /**
     * Retrieves favorite inventory items of a user by user ID.
     *
     * @param userId The ID of the user.
     * @return A list of favorite inventory items of the user.
     */
    public List<FavoriteInventoryDTO> getFavoritesByUserId(int userId) {
        return favoriteInventoryDao.getFavoritesByUserId(userId);
    }

    /**
     * Retrieves a favorite inventory item by its ID.
     *
     * @param favoriteId The ID of the favorite inventory item.
     * @return The favorite inventory item with the specified ID.
     */
    public FavoriteInventoryDTO getFavoriteById(int favoriteId) {
        return favoriteInventoryDao.getFavoriteById(favoriteId);
    }

    /**
     * Adds a favorite inventory item to the database.
     *
     * @param favorite The favorite inventory item to be added.
     */
    public void addFavorite(FavoriteInventoryDTO favorite) {
        favoriteInventoryDao.insertFavorite(favorite);
    }

    /**
     * Deletes a favorite inventory item from the database by its ID.
     *
     * @param favoriteId The ID of the favorite inventory item to be deleted.
     */
    public void deleteFavorite(int favoriteId) {
        favoriteInventoryDao.deleteFavoriteById(favoriteId);
    }
    
    /**
     * Checks if an inventory item is already marked as a favorite by a user.
     *
     * @param inventoryId The ID of the inventory item.
     * @param userId The ID of the user.
     * @return true if the inventory item is already marked as a favorite by the user, false otherwise.
     */
    public boolean isFavorite(int inventoryId, int userId){
        return favoriteInventoryDao.isFavoriteAlreadyExists(inventoryId, userId);
    }

    /**
     * Retrieves the ID of a favorite inventory item by its inventory ID and user ID.
     *
     * @param inventoryId The ID of the inventory item.
     * @param userId The ID of the user.
     * @return The ID of the favorite inventory item.
     */
    public int getFavoriteIdByInventoryIdAndUserId(int inventoryId, int userId) {
        return favoriteInventoryDao.getFavoriteIdByInventoryIdAndUserId(inventoryId, userId);
    }
}
