package businesslayer;

import DAO.RetailerInventoryDAOImpl;
import DTO.RetailerInventoryDTO;
import java.util.Date;
import java.util.List;

/**
 * Handles business logic related to retailer inventory management.
 */
public class RetailerInventoryBusinessLogic {
    private RetailerInventoryDAOImpl retailerInventoryDao = null;

    /**
     * Constructs a RetailerInventoryBusinessLogic object and initializes the DAO.
     */
    public RetailerInventoryBusinessLogic() {
        retailerInventoryDao = new RetailerInventoryDAOImpl();
    }

    /**
     * Retrieves all retailer inventories from the database.
     *
     * @return A list of all retailer inventories.
     */
    public List<RetailerInventoryDTO> getAllInventories() {
        return retailerInventoryDao.getAllInventories();
    }
    
    /**
     * Retrieves retailer inventories by their ID.
     *
     * @param inventoryId The ID of the inventory.
     * @return A list of retailer inventories with the specified ID.
     */
    public List<RetailerInventoryDTO> getInventoriesById(int inventoryId){
        return retailerInventoryDao.getInventoriesByUserId(inventoryId);
    }
    
    /**
     * Retrieves a retailer inventory by its ID.
     *
     * @param inventoryId The ID of the inventory.
     * @return The retailer inventory with the specified ID.
     */
    public RetailerInventoryDTO getInventoryById(int inventoryId){
        return retailerInventoryDao.getInventoryById(inventoryId);
    }

    /**
     * Adds a retailer inventory to the database.
     *
     * @param inventory The retailer inventory to be added.
     */
    public void addInventory(RetailerInventoryDTO inventory) {
        retailerInventoryDao.insertInventory(inventory);
    }
    
    /**
     * Updates an existing retailer inventory in the database.
     *
     * @param inventory The retailer inventory to be updated.
     */
    public void updateInventory(RetailerInventoryDTO inventory){
        retailerInventoryDao.updateInventory(inventory);
    }
    
    /**
     * Deletes a retailer inventory from the database.
     *
     * @param inventory The retailer inventory to be deleted.
     */
    public void deleteInventory(RetailerInventoryDTO inventory){
        retailerInventoryDao.deleteInventory(inventory);
    }
    
    /**
     * Checks if a food name already exists in retailer inventories.
     *
     * @param foodName The name of the food item.
     * @return true if the food name already exists, false otherwise.
     */
    public boolean isFoodNameAlreadyExists(String foodName){
        return retailerInventoryDao.isFoodNameAlreadyExists(foodName);
    }
    
    /**
     * Retrieves newly added items since the last login of a user.
     *
     * @param userId The ID of the user.
     * @param lastLoginDate The last login date of the user.
     * @return A list of newly added items.
     */
    public List<RetailerInventoryDTO> getNewlyAddedItems(int userId, Date lastLoginDate) {
        return retailerInventoryDao.getNewlyAddedItems(userId, lastLoginDate);
    }
    
    /**
     * Updates the food amount of a retailer inventory item.
     *
     * @param inventory The retailer inventory item to be updated.
     */
    public void updateInventoryFoodAmount(RetailerInventoryDTO inventory){
        retailerInventoryDao.updateInventoryFoodAmount(inventory);
    }
    
    /**
     * Checks if a food item with a specific retailer exists in the inventory.
     *
     * @param foodName The name of the food item.
     * @param retailer The name of the retailer.
     * @return true if the food item with the retailer exists, false otherwise.
     */
    public boolean isFoodNameAndRetailerExists(String foodName, String retailer){
        return retailerInventoryDao.isFoodNameAndRetailerExists(foodName, retailer);
    }
    
    /**
     * Checks if a retailer inventory item is surplus.
     *
     * @param inventory The retailer inventory item.
     * @return true if the retailer inventory item is surplus, false otherwise.
     */
    public boolean isSurPlus(RetailerInventoryDTO inventory){
        return retailerInventoryDao.isSurPlus(inventory);
    }
    
    /**
     * Checks if a user can buy an item based on their balance.
     *
     * @param userId The ID of the user.
     * @param itemPrice The price of the item.
     * @return true if the user can buy the item, false otherwise.
     */
    public boolean canUserBuyItem(int userId, double itemPrice) {
        return retailerInventoryDao.canUserBuyItem(userId, itemPrice);
    }
}
