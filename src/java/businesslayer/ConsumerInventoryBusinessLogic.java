package businesslayer;

import DAO.ConsumerInventoryDAOImpl;
import DTO.ConsumerInventoryDTO;
import java.util.List;

public class ConsumerInventoryBusinessLogic {
    private ConsumerInventoryDAOImpl consumerInventoryDao = null;

    public ConsumerInventoryBusinessLogic() {
        consumerInventoryDao = new ConsumerInventoryDAOImpl();
    }

    public List<ConsumerInventoryDTO> getAllInventories() {
        return consumerInventoryDao.getAllInventories();
    }
    
    public ConsumerInventoryDTO getInventoryById(int inventoryId){
        return consumerInventoryDao.getInventoryById(inventoryId);
    }

    public void addInventory(ConsumerInventoryDTO inventory) {
        consumerInventoryDao.insertInventory(inventory);
    } 
}
