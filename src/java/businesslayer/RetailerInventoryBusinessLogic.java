package businesslayer;

import DAO.RetailerInventoryDAOImpl;
import DTO.RetailerInventoryDTO;
import java.util.Date;
import java.util.List;

/**
 * Business logic layer for Retailer Inventory operations.
 */
public class RetailerInventoryBusinessLogic {
    private RetailerInventoryDAOImpl retailerInventoryDao = null;

    /**
     * Initializes a new instance of the RetailerInventoryBusinessLogic class.
     */
    public RetailerInventoryBusinessLogic() {
        retailerInventoryDao = new RetailerInventoryDAOImpl();
    }

    /**
     * Retrieves all retailer inventories.
     *
     * @return a list of RetailerInventoryDTO representing all retailer inventories
     */
    public List<RetailerInventoryDTO> getAllInventories() {
        return retailerInventoryDao.getAllInventories();
    }
    
    /**
     * Retrieves retailer inventories by inventory ID.
     *
     * @param inventoryId the ID of the inventory
     * @return a list of RetailerInventoryDTO representing retailer inventories with the specified ID
     */
    public List<RetailerInventoryDTO> getInventoriesById(int inventoryId){
        return retailerInventoryDao.getInventoriesByUserId(inventoryId);
    }
    
    /**
     * Retrieves a retailer inventory by its ID.
     *
     * @param inventoryId the ID of the inventory to retrieve
     * @return the RetailerInventoryDTO representing the retailer inventory with the specified ID
     */
    public RetailerInventoryDTO getInventoryById(int inventoryId){
        return retailerInventoryDao.getInventoryById(inventoryId);
    }

    /**
     * Adds a new retailer inventory.
     *
     * @param inventory the RetailerInventoryDTO representing the retailer inventory to add
     */
    public void addInventory(RetailerInventoryDTO inventory) {
        retailerInventoryDao.insertInventory(inventory);
    }
    
    /**
     * Updates an existing retailer inventory.
     *
     * @param inventory the RetailerInventoryDTO representing the retailer inventory to update
     */
    public void updateInventory(RetailerInventoryDTO inventory){
        retailerInventoryDao.updateInventory(inventory);
    }
    
    /**
     * Checks if a food name already exists in retailer inventories.
     *
     * @param foodName the name of the food to check
     * @return true if the food name already exists, otherwise false
     */
    public boolean isFoodNameAlreadyExists(String foodName){
        return retailerInventoryDao.isFoodNameAlreadyExists(foodName);
    }
    
    /**
     * Retrieves newly added items since the last login date for a specific user.
     *
     * @param userId the ID of the user
     * @param lastLoginDate the last login date of the user
     * @return a list of RetailerInventoryDTO representing newly added items since the last login date
     */
    public List<RetailerInventoryDTO> getNewlyAddedItems(int userId, Date lastLoginDate) {
        return retailerInventoryDao.getNewlyAddedItems(userId, lastLoginDate);
    }
    
    /**
     * Updates the food amount for a retailer inventory.
     *
     * @param inventory the RetailerInventoryDTO representing the retailer inventory to update
     */
    public void updateInventoryFoodAmount(RetailerInventoryDTO inventory){
        retailerInventoryDao.updateInventoryFoodAmount(inventory);
    }
    
    /**
     * Checks if a food name and retailer already exist in retailer inventories.
     *
     * @param foodName the name of the food to check
     * @param retailer the name of the retailer to check
     * @return true if the food name and retailer already exist, otherwise false
     */
    public boolean isFoodNameAndRetailerExists(String foodName, String retailer){
        return retailerInventoryDao.isFoodNameAndRetailerExists(foodName, retailer);
    }
    
    public boolean isSurPlus(RetailerInventoryDTO inventory){
        return retailerInventoryDao.isSurPlus(inventory);
    }

    /**
     * Deletes a retailer inventory.
     *
     * @param inventory the RetailerInventoryDTO representing the retailer inventory to delete
     */
    public void deleteInventory(RetailerInventoryDTO inventory) {
        retailerInventoryDao.deleteInventory(inventory);

    }
}
