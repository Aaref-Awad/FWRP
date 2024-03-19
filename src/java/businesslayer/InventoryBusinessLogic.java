/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package businesslayer;


import DAO.InventoryDAOImpl;
import DTO.InventoryDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aaref
 */
public class InventoryBusinessLogic {
           private InventoryDAOImpl inventoryDao = null;

    public InventoryBusinessLogic() {
        inventoryDao = new InventoryDAOImpl();
    }

    public List<InventoryDTO> getAllFoodItems() throws SQLException {
        return inventoryDao.getAllFoodItems();
    }

    public void addFood(InventoryDTO food) {
        inventoryDao.insertFood(food);
    } 
}
