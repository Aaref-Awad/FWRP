package DAO;

import DTO.RetailerInventoryDTO;
import java.util.List;

/**
 *
 * @author Aaref
 */
public interface RetailerInventoryDAO {
    // CRUD operations
    public List<RetailerInventoryDTO> getAllInventories();
    public RetailerInventoryDTO getInventoryById(int inventoryId);
    public List<RetailerInventoryDTO> getInventoriesByUserId(int userId);
    public void insertInventory(RetailerInventoryDTO inventory);
    public void updateInventory(RetailerInventoryDTO inventory);
    public void deleteInventory(RetailerInventoryDTO inventory);
}
