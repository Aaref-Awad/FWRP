package businesslayer;

import DAO.FavoriteInventoryDAOImpl;
import DTO.FavoriteInventoryDTO;
import java.util.List;

/**
 * Business logic layer for Favorite Inventory operations.
 */
public class FavoriteInventoryBusinessLogic {
    private FavoriteInventoryDAOImpl favoriteInventoryDao = null;

    /**
     * Initializes a new instance of the FavoriteInventoryBusinessLogic class.
     */
    public FavoriteInventoryBusinessLogic() {
        favoriteInventoryDao = new FavoriteInventoryDAOImpl();
    }

    /**
     * Retrieves all favorite inventories.
     *
     * @return a list of FavoriteInventoryDTO representing all favorite inventories
     */
    public List<FavoriteInventoryDTO> getAllFavorites() {
        return favoriteInventoryDao.getAllFavorites();
    }

    /**
     * Retrieves favorite inventories by user ID.
     *
     * @param userId the ID of the user
     * @return a list of FavoriteInventoryDTO representing favorite inventories of the specified user
     */
    public List<FavoriteInventoryDTO> getFavoritesByUserId(int userId) {
        return favoriteInventoryDao.getFavoritesByUserId(userId);
    }

    /**
     * Retrieves a favorite inventory by its ID.
     *
     * @param favoriteId the ID of the favorite inventory to retrieve
     * @return the FavoriteInventoryDTO representing the favorite inventory with the specified ID
     */
    public FavoriteInventoryDTO getFavoriteById(int favoriteId) {
        return favoriteInventoryDao.getFavoriteById(favoriteId);
    }

    /**
     * Adds a new favorite inventory.
     *
     * @param favorite the FavoriteInventoryDTO representing the favorite inventory to add
     */
    public void addFavorite(FavoriteInventoryDTO favorite) {
        favoriteInventoryDao.insertFavorite(favorite);
    }

    /**
     * Deletes a favorite inventory by its ID.
     *
     * @param favoriteId the ID of the favorite inventory to delete
     */
    public void deleteFavorite(int favoriteId) {
        favoriteInventoryDao.deleteFavoriteById(favoriteId);
    }
    
    /**
     * Checks if a favorite inventory already exists.
     *
     * @param inventoryId the ID of the inventory
     * @param userId the ID of the user
     * @return true if the favorite inventory already exists, otherwise false
     */
    public boolean isFavorite(int inventoryId, int userId){
        return favoriteInventoryDao.isFavoriteAlreadyExists(inventoryId, userId);
    }

    /**
     * Retrieves the favorite ID by inventory ID and user ID.
     *
     * @param inventoryId the ID of the inventory
     * @param userId the ID of the user
     * @return the favorite ID associated with the inventory ID and user ID, or -1 if not found
     */
    public int getFavoriteIdByInventoryIdAndUserId(int inventoryId, int userId) {
        return favoriteInventoryDao.getFavoriteIdByInventoryIdAndUserId(inventoryId, userId);
    }
}
