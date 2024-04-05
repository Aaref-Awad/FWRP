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
    
    public List<RetailerInventoryDTO> getInventoryById(int inventoryId){
        return retailerInventoryDao.getInventoriesByUserId(inventoryId);
    }

    public void addInventory(RetailerInventoryDTO inventory) {
        retailerInventoryDao.insertInventory(inventory);
    } 
}
