package businesslayer;

import DAO.CharityInventoryDAOImpl;
import DTO.CharityInventoryDTO;
import DTO.RetailerInventoryDTO;
import java.util.Date;
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
    public void updateInventory(CharityInventoryDTO inventory){
        charityInventoryDao.updateInventory(inventory);
    }
    public List<RetailerInventoryDTO> getNewlyAddedItems(int userId, Date lastLoginDate) {
       return charityInventoryDao.getNewlyAddedItems(userId, lastLoginDate);
    }
    public boolean isFoodNameAndRetailerExists(String foodName, String retailer){
        return charityInventoryDao.isFoodNameAndRetailerExists(foodName, retailer);
    }

    
}
