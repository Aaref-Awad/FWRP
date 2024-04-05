package businesslayer;

import DAO.CharityInventoryDAOImpl;
import DTO.CharityInventoryDTO;
import java.util.List;

public class CharityInventoryBusinessLogic {
    private CharityInventoryDAOImpl charityInventoryDao = null;

    public CharityInventoryBusinessLogic() {
        charityInventoryDao = new CharityInventoryDAOImpl();
    }

    public List<CharityInventoryDTO> getAllInventories() {
        return charityInventoryDao.getAllInventories();
    }
    
    public CharityInventoryDTO getInventoryById(int inventoryId){
        return charityInventoryDao.getInventoryById(inventoryId);
    }

    public void addInventory(CharityInventoryDTO inventory) {
        charityInventoryDao.insertInventory(inventory);
    } 
}
