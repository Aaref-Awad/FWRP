package DAO;

import DTO.ConsumerInventoryDTO;
import java.util.List;

/**
 *
 * @author Aaref
 */
public interface ConsumerInventoryDAO {
    // CRUD operations
    public List<ConsumerInventoryDTO> getAllInventories();
    public ConsumerInventoryDTO getInventoryById(int inventoryId);
    public List<ConsumerInventoryDTO> getInventoriesByConsumerId(int consumerId);
    public void insertInventory(ConsumerInventoryDTO inventory);
    public void updateInventory(ConsumerInventoryDTO inventory);
    public void deleteInventory(ConsumerInventoryDTO inventory);
}
