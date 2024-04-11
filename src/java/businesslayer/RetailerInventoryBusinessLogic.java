package businesslayer;

import DAO.RetailerInventoryDAOImpl;
import DTO.RetailerInventoryDTO;
import java.util.Date;
import java.util.List;

public class RetailerInventoryBusinessLogic {
    private RetailerInventoryDAOImpl retailerInventoryDao = null;

    public RetailerInventoryBusinessLogic() {
        retailerInventoryDao = new RetailerInventoryDAOImpl();
    }

    public List<RetailerInventoryDTO> getAllInventories() {
        return retailerInventoryDao.getAllInventories();
    }
    
    public List<RetailerInventoryDTO> getInventoriesById(int inventoryId){
        return retailerInventoryDao.getInventoriesByUserId(inventoryId);
    }
    
    public RetailerInventoryDTO getInventoryById(int inventoryId){
        return retailerInventoryDao.getInventoryById(inventoryId);
    }

    public void addInventory(RetailerInventoryDTO inventory) {
        retailerInventoryDao.insertInventory(inventory);
    }
    
    public void updateInventory(RetailerInventoryDTO inventory){
        retailerInventoryDao.updateInventory(inventory);
    }
    
    public void deleteInventory(RetailerInventoryDTO inventory){
        retailerInventoryDao.deleteInventory(inventory);
    }
    
    public boolean isFoodNameAlreadyExists(String foodName){
        return retailerInventoryDao.isFoodNameAlreadyExists(foodName);
    }
    
    public List<RetailerInventoryDTO> getNewlyAddedItems(int userId, Date lastLoginDate) {
        return retailerInventoryDao.getNewlyAddedItems(userId, lastLoginDate);
    }
    public void updateInventoryFoodAmount(RetailerInventoryDTO inventory){
        retailerInventoryDao.updateInventoryFoodAmount(inventory);
    }
    
    public boolean isFoodNameAndRetailerExists(String foodName, String retailer){
        return retailerInventoryDao.isFoodNameAndRetailerExists(foodName, retailer);
    }
    
    public boolean isSurPlus(RetailerInventoryDTO inventory){
        return retailerInventoryDao.isSurPlus(inventory);
    }

}
