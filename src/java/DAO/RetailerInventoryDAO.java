package DAO;

import DTO.RetailerInventoryDTO;
import java.util.Date;
import java.util.List;

/**
 * The DAO interface for managing retailer inventory items.
 */
public interface RetailerInventoryDAO {

    /**
     * Retrieves all retailer inventory items.
     * @return A list of all retailer inventory items.
     */
    public List<RetailerInventoryDTO> getAllInventories();

    /**
     * Retrieves a retailer inventory item by its ID.
     * @param inventoryId The ID of the inventory item to retrieve.
     * @return The retailer inventory item with the specified ID, or null if not found.
     */
    public RetailerInventoryDTO getInventoryById(int inventoryId);

    /**
     * Retrieves all retailer inventory items for a specific user.
     * @param userId The ID of the user.
     * @return A list of all retailer inventory items for the specified user.
     */
    public List<RetailerInventoryDTO> getInventoriesByUserId(int userId);

    /**
     * Inserts a new retailer inventory item.
     * @param inventory The retailer inventory item to insert.
     */
    public void insertInventory(RetailerInventoryDTO inventory);

    /**
     * Updates an existing retailer inventory item.
     * @param inventory The retailer inventory item to update.
     */
    public void updateInventory(RetailerInventoryDTO inventory);

    /**
     * Deletes a retailer inventory item.
     * @param inventory The retailer inventory item to delete.
     */
    public void deleteInventory(RetailerInventoryDTO inventory);

    /**
     * Checks if a food item with the given name already exists.
     * @param foodName The name of the food item.
     * @return true if the food item already exists, false otherwise.
     */
    public boolean isFoodNameAlreadyExists(String foodName);

    /**
     * Retrieves newly added inventory items since the user's last login date.
     * @param userId The ID of the user.
     * @param lastLoginDate The last login date of the user.
     * @return A list of newly added inventory items.
     */
    public List<RetailerInventoryDTO> getNewlyAddedItems(int userId, Date lastLoginDate);

    /**
     * Updates the amount of food in the inventory item.
     * @param inventory The retailer inventory item to update.
     */
    public void updateInventoryFoodAmount(RetailerInventoryDTO inventory);

    /**
     * Checks if a food item with the given name and retailer already exists.
     * @param foodName The name of the food item.
     * @param retailer The name of the retailer.
     * @return true if the food item already exists, false otherwise.
     */
    public boolean isFoodNameAndRetailerExists(String foodName, String retailer);

    /**
     * Checks if the inventory item is surplus.
     * @param inventory The retailer inventory item to check.
     * @return true if the inventory item is surplus, false otherwise.
     */
    public boolean isSurPlus(RetailerInventoryDTO inventory);

    /**
     * Checks if the user can buy the item based on the item price.
     * @param userId The ID of the user.
     * @param itemPrice The price of the item.
     * @return true if the user can buy the item, false otherwise.
     */
    public boolean canUserBuyItem(int userId, double itemPrice);

}
