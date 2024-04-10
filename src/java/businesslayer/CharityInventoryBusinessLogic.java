package businesslayer;

import DAO.CharityInventoryDAOImpl;
import DTO.CharityInventoryDTO;
import java.util.List;

import DTO.RetailerInventoryDTO;
import java.util.Date;

import java.util.List;

/**
 * Business logic layer for Charity Inventory operations.
 */
public class CharityInventoryBusinessLogic {
    private CharityInventoryDAOImpl charityInventoryDao = null;

    /**
     * Initializes a new instance of the CharityInventoryBusinessLogic class.
     */
    public CharityInventoryBusinessLogic() {
        charityInventoryDao = new CharityInventoryDAOImpl();
    }

    /**
     * Retrieves all charity inventories.
     *
     * @return a list of CharityInventoryDTO representing all charity inventories
     */
    public List<CharityInventoryDTO> getAllInventories() {
        return charityInventoryDao.getAllInventories();
    }
    
    /**
     * Retrieves a charity inventory by its ID.
     *
     * @param inventoryId the ID of the inventory to retrieve
     * @return the CharityInventoryDTO representing the inventory with the specified ID
     */
    public CharityInventoryDTO getInventoryById(int inventoryId){
        return charityInventoryDao.getInventoryById(inventoryId);
    }

    /**
     * Adds a new inventory to the charity inventory.
     *
     * @param inventory the CharityInventoryDTO representing the inventory to add
     */
    public void addInventory(CharityInventoryDTO inventory) {
        charityInventoryDao.insertInventory(inventory);
    }
    

    /**
     * Updates an existing inventory in the charity inventory.
     *
     * @param inventory the CharityInventoryDTO representing the inventory to update
     */

    public void addRetailerInventory(RetailerInventoryDTO inventory) {
        charityInventoryDao.insertRetailerInventory(inventory);
    }

    public void updateInventory(CharityInventoryDTO inventory){
        charityInventoryDao.updateInventory(inventory);
    }

    
    /**
     * Deletes an existing inventory in the charity inventory.
     *
     * @param inventory the CharityInventoryDTO representing the inventory to delete
     */
    public void deleteInventory(CharityInventoryDTO inventory){
        charityInventoryDao.deleteInventory(inventory);
    }

    public List<RetailerInventoryDTO> getNewlyAddedItems(int userId, Date lastLoginDate) {
       return charityInventoryDao.getNewlyAddedItems(userId, lastLoginDate);
    }
    public boolean isFoodNameAndRetailerExists(String foodName, String retailer){
        return charityInventoryDao.isFoodNameAndRetailerExists(foodName, retailer);
    }

    

}
