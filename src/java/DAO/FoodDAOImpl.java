package DAO;

import DTO.FoodDTO;
import data.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aaref
 */
public class FoodDAOImpl implements FoodDAO {
    
    private static Connection con = DataSource.getInstance().getConnection();
    private static PreparedStatement pstmt;
    private static ResultSet rs;
	
    @Override
    public List<FoodDTO> getAllFoods() {
      
        ArrayList<FoodDTO> foods = null;

        try {
            String query = "SELECT * FROM Food ORDER BY FoodID";
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery();
            foods = new ArrayList<>();
            while (rs.next()) {
                FoodDTO food = new FoodDTO();
                food.setFoodID(rs.getInt("FoodID"));
                food.setFoodName(rs.getString("FoodName"));
              
                foods.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return foods;
    }

    @Override
    public FoodDTO getFoodById(int foodId) {
       
        FoodDTO food = null;

        try {
            
            pstmt = con.prepareStatement(
                    "SELECT * FROM Food WHERE FoodID = ?");
            pstmt.setInt(1, foodId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                food = new FoodDTO();
                food.setFoodID(rs.getInt("FoodID"));
                food.setFoodName(rs.getString("FoodName"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return food;
    }
    
    public FoodDTO getFoodByName(String foodName) {
       
        FoodDTO food = null;

        try {
            
            pstmt = con.prepareStatement(
                    "SELECT * FROM Food WHERE FoodName = ?");
            pstmt.setString(1, foodName);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                food = new FoodDTO();
                food.setFoodID(rs.getInt("FoodID"));
                food.setFoodName(rs.getString("FoodName"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return food;
    }

    @Override
    public void insertFood(FoodDTO food) {
        try {
            pstmt = con.prepareStatement(
                    "INSERT INTO Food (FoodName) "
                    + "VALUES( ?)");
            pstmt.setString(1, food.getFoodName());
            pstmt.executeUpdate();
              
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFood(FoodDTO food) {      
        try {
            
            pstmt = con.prepareStatement(
                    "UPDATE Food SET FoodName=? WHERE FoodID=?");
            pstmt.setString(1, food.getFoodName());
            pstmt.setInt(2, food.getFoodID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFood(FoodDTO food) {
        try {
            
            pstmt = con.prepareStatement(
                    "DELETE FROM Food WHERE FoodID = ?");
            pstmt.setInt(1, food.getFoodID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
