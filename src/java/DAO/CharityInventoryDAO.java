package DAO;

import DTO.CharityInventoryDTO;
import DTO.RetailerInventoryDTO;
import java.util.Date;
import java.util.List;

/**
 * DAO Interface for Charity Inventory
 */
public interface CharityInventoryDAO {
    /**
     * Retrieves all Charity Inventory records.
     *
     * @return a list of all Charity Inventory records
     */
    public List<CharityInventoryDTO> getAllInventories();

    /**
     * Retrieves a Charity Inventory record by its ID.
     *
     * @param inventoryId the ID of the Charity Inventory record to retrieve
     * @return the Charity Inventory record with the specified ID, or null if not found
     */
    public CharityInventoryDTO getInventoryById(int inventoryId);

    /**
     * Retrieves all Charity Inventory records associated with a specific charity.
     *
     * @param charityId the ID of the charity
     * @return a list of Charity Inventory records associated with the specified charity
     */
    public List<CharityInventoryDTO> getInventoriesByCharityId(int charityId);

    /**
     * Inserts a new Charity Inventory record.
     *
     * @param inventory the Charity Inventory record to insert
     */
    public void insertInventory(CharityInventoryDTO inventory);

    /**
     * Updates an existing Charity Inventory record.
     *
     * @param inventory the Charity Inventory record to update
     */
    public void updateInventory(CharityInventoryDTO inventory);

    /**
     * Deletes a Charity Inventory record.
     *
     * @param inventory the Charity Inventory record to delete
     */
    public void deleteInventory(CharityInventoryDTO inventory);

    /**
     * Retrieves a list of newly added items based on the user ID and last login date.
     *
     * @param userId        the ID of the user
     * @param lastLoginDate the date of the last login
     * @return a list of newly added items
     */
    public List<RetailerInventoryDTO> getNewlyAddedItems(int userId, Date lastLoginDate);

    /**
     * Checks if a food name and retailer combination exists.
     *
     * @param foodName the name of the food
     * @param retailer the name of the retailer
     * @return true if the combination exists, false otherwise
     */
    public boolean isFoodNameAndRetailerExists(String foodName, String retailer);

    /**
     * Checks if a food name and charity ID combination exists.
     *
     * @param foodName  the name of the food
     * @param charityId the ID of the charity
     * @return true if the combination exists, false otherwise
     */
    public boolean isCharityFoodNameAndRetailerExists(String foodName, int charityId);
}
