package businesslayer;

import DAO.CharityInventoryDAOImpl;
import DTO.CharityInventoryDTO;
import DTO.RetailerInventoryDTO;
import java.util.Date;
import java.util.List;

/**
 * Handles business logic related to charity inventory management.
 */
public class CharityInventoryBusinessLogic {
    private CharityInventoryDAOImpl charityInventoryDao = null;

    /**
     * Constructs a CharityInventoryBusinessLogic object and initializes the DAO.
     */
    public CharityInventoryBusinessLogic() {
        charityInventoryDao = new CharityInventoryDAOImpl();
    }

    /**
     * Retrieves all inventories from the database.
     *
     * @return A list of all inventories.
     */
    public List<CharityInventoryDTO> getAllInventories() {
        return charityInventoryDao.getAllInventories();
    }
    
    /**
     * Retrieves an inventory by its ID.
     *
     * @param inventoryId The ID of the inventory.
     * @return The inventory with the specified ID.
     */
    public CharityInventoryDTO getInventoryById(int inventoryId){
        return charityInventoryDao.getInventoryById(inventoryId);
    }

    /**
     * Adds an inventory to the database.
     *
     * @param inventory The inventory to be added.
     */
    public void addInventory(CharityInventoryDTO inventory) {
        charityInventoryDao.insertInventory(inventory);
    }
    
    /**
     * Adds a retailer inventory to the database.
     *
     * @param inventory The retailer inventory to be added.
     */
    public void addRetailerInventory(RetailerInventoryDTO inventory) {
        charityInventoryDao.insertRetailerInventory(inventory);
    }

    /**
     * Updates an existing inventory in the database.
     *
     * @param inventory The inventory to be updated.
     */
    public void updateInventory(CharityInventoryDTO inventory){
        charityInventoryDao.updateInventory(inventory);
    }
    
    /**
     * Deletes an inventory from the database.
     *
     * @param inventory The inventory to be deleted.
     */
    public void deleteInventory(CharityInventoryDTO inventory){
        charityInventoryDao.deleteInventory(inventory);
    }

    /**
     * Retrieves newly added items since the last login of a user.
     *
     * @param userId The ID of the user.
     * @param lastLoginDate The last login date of the user.
     * @return A list of newly added items.
     */
    public List<RetailerInventoryDTO> getNewlyAddedItems(int userId, Date lastLoginDate) {
       return charityInventoryDao.getNewlyAddedItems(userId, lastLoginDate);
    }
    
    /**
     * Checks if a food item with a specific retailer exists in the inventory.
     *
     * @param foodName The name of the food item.
     * @param retailer The name of the retailer.
     * @return true if the food item with the retailer exists, false otherwise.
     */
    public boolean isFoodNameAndRetailerExists(String foodName, String retailer){
        return charityInventoryDao.isFoodNameAndRetailerExists(foodName, retailer);
    }
    
    /**
     * Checks if a food item with a specific charity and name exists in the inventory.
     *
     * @param foodName The name of the food item.
     * @param charityId The ID of the charity.
     * @return true if the food item with the charity and name exists, false otherwise.
     */
    public boolean isCharityFoodNameAndRetailerExists(String foodName, int charityId){
      return charityInventoryDao.isCharityFoodNameAndRetailerExists(foodName, charityId);
    }  
}
