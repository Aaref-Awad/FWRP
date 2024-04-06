package DAO;

import DTO.CharityInventoryDTO;
import java.util.List;

/**
 * DAO Interface for Charity Inventory
 */
public interface CharityInventoryDAO {
    // CRUD operations
    public List<CharityInventoryDTO> getAllInventories();
    public CharityInventoryDTO getInventoryById(int inventoryId);
    public List<CharityInventoryDTO> getInventoriesByCharityId(int charityId);
    public void insertInventory(CharityInventoryDTO inventory);
    public void updateInventory(CharityInventoryDTO inventory);
    public void deleteInventory(CharityInventoryDTO inventory);
}
