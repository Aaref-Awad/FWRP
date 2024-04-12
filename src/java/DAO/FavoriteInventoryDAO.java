package DAO;

import DTO.FavoriteInventoryDTO;
import java.util.List;

/**
 * The DAO interface for managing favorite inventory items.
 */
public interface FavoriteInventoryDAO {

    /**
     * Retrieves all favorite inventory items.
     * @return A list of all favorite inventory items.
     */
    public List<FavoriteInventoryDTO> getAllFavorites();

    /**
     * Retrieves a favorite inventory item by its ID.
     * @param favoriteId The ID of the favorite inventory item to retrieve.
     * @return The favorite inventory item with the specified ID, or null if not found.
     */
    public FavoriteInventoryDTO getFavoriteById(int favoriteId);

    /**
     * Retrieves all favorite inventory items for a specific user.
     * @param userId The ID of the user.
     * @return A list of all favorite inventory items for the specified user.
     */
    public List<FavoriteInventoryDTO> getFavoritesByUserId(int userId);

    /**
     * Inserts a new favorite inventory item.
     * @param favorite The favorite inventory item to insert.
     */
    public void insertFavorite(FavoriteInventoryDTO favorite);

    /**
     * Updates an existing favorite inventory item.
     * @param favorite The favorite inventory item to update.
     */
    public void updateFavorite(FavoriteInventoryDTO favorite);

    /**
     * Deletes a favorite inventory item.
     * @param favorite The favorite inventory item to delete.
     */
    public void deleteFavorite(FavoriteInventoryDTO favorite);

    /**
     * Checks if a favorite inventory item already exists.
     * @param inventoryId The ID of the inventory item.
     * @param userId The ID of the user.
     * @return true if the favorite inventory item already exists, false otherwise.
     */
    public boolean isFavoriteAlreadyExists(int inventoryId, int userId);

    /**
     * Deletes a favorite inventory item by its ID.
     * @param favoriteId The ID of the favorite inventory item to delete.
     */
    public void deleteFavoriteById(int favoriteId);

    /**
     * Retrieves the ID of a favorite inventory item by inventory ID and user ID.
     * @param inventoryId The ID of the inventory item.
     * @param userId The ID of the user.
     * @return The ID of the favorite inventory item, or -1 if not found.
     */
    public int getFavoriteIdByInventoryIdAndUserId(int inventoryId, int userId);
}
