package DAO;

import DTO.FoodDTO;
import java.util.List;

/**
 *
 * @author Aaref
 */
public interface FoodDAO {
    // CRUD operations
    public List<FoodDTO> getAllFoods();
    public FoodDTO getFoodById(int foodId);
    public void insertFood(FoodDTO food);
    public void updateFood(FoodDTO food);
    public void deleteFood(FoodDTO food);
}
