/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import DTO.InventoryDTO;
import java.util.List;

/**
 *
 * @author Owner
 */
public interface InventoryDAO {
     // CRUD operations
    public List<InventoryDTO> getAllFoodItems();
    public InventoryDTO getFoodById(int foodID);
    public void insertFood(InventoryDTO food);
    public void updateFood(InventoryDTO food);
    public void deleteFood(InventoryDTO food);
}
