package businesslayer;

import DAO.RetailerInventoryDAOImpl;
import DTO.RetailerInventoryDTO;
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
}
