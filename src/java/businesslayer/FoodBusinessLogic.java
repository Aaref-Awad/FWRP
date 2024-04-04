package businesslayer;

import DAO.FoodDAOImpl;
import DTO.FoodDTO;
import java.util.List;

public class FoodBusinessLogic {
    private FoodDAOImpl foodDao = null;

    public FoodBusinessLogic() {
        foodDao = new FoodDAOImpl();
    }

    public List<FoodDTO> getAllFoods() {
        return foodDao.getAllFoods();
    }
    
    public FoodDTO getFoodById(int foodId){
        return foodDao.getFoodById(foodId);
    }

    public FoodDTO getFoodByName(String foodName){
        return foodDao.getFoodByName(foodName);
    }

    public void addFood(FoodDTO food) {
        foodDao.insertFood(food);
    } 
}
