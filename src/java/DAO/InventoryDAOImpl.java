/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.InventoryDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Owner
 */
public class InventoryDAOImpl implements InventoryDAO{
    
     private static Connection con = DataSource.getInstance().getConnection();;
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    @Override
    public List<InventoryDTO> getAllFoodItems() {
        ArrayList<InventoryDTO> items = null;

        try {
            

            String query = "SELECT * FROM inventory ORDER BY FoodID";
            pstmt = con.prepareStatement(query);

            rs = pstmt.executeQuery();
            items = new ArrayList<>();
            while (rs.next()) {
                InventoryDTO food = new InventoryDTO();
                int foodID = rs.getInt("FoodID");
                food.setFoodID(foodID);
                
                String foodName = rs.getString("FoodName");
                food.setFoodName(foodName);
                
                int foodAmount = rs.getInt("FoodAmount");
                food.setFoodAmount(foodAmount);
                
                double price = rs.getDouble("Price");
                food.setPrice(price);
                
                Date expirationDate = rs.getDate("ExpirationDate");
                food.setExpirationDate(expirationDate);
                
                String surplusType = rs.getString("SurplusType");
                food.setSurplusType(surplusType);
              
                items.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//
//                if (pstmt != null) {
//                    pstmt.close();
//                }
//
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
        }
        return items;
    }

    @Override
    public InventoryDTO getFoodById(int foodID) {
        InventoryDTO food = null;

        try {
            
            pstmt = con.prepareStatement(
                    "SELECT * FROM Inventory WHERE FoodID = ?");
            pstmt.setInt(1, foodID);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                food = new InventoryDTO();
                String foodName = rs.getString("FoodName");
                food.setFoodName(foodName);
                
                int foodAmount = rs.getInt("FoodAmount");
                food.setFoodAmount(foodAmount);
                
                double price = rs.getDouble("Price");
                food.setPrice(price);
                
                Date expirationDate = rs.getDate("ExpirationDate");
                food.setExpirationDate(expirationDate);
                
                String surplusType = rs.getString("SurplusType");
                food.setSurplusType(surplusType);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//
//                if (pstmt != null) {
//                    pstmt.close();
//                }
//
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
        }
        return food;
    }
    @Override
    public void insertFood(InventoryDTO food) {
        
       try {
            InventoryDTO existingData = getFoodById(food.getFoodID());
            if (existingData == null) {

               

                pstmt = con.prepareStatement(
                        "INSERT INTO Inventory (FoodID, FoodName, FoodAmount, Price, ExpirationDate, SurplusType) "
                        + "VALUES(?, ?, ?, ?, ?)");
                pstmt.setInt(1, food.getFoodID());
                pstmt.setString(2, food.getFoodName());
                pstmt.setInt(3, food.getFoodAmount());
                pstmt.setDouble(4, food.getPrice());
                pstmt.setDate(5, food.getExpirationDate());
                pstmt.setString(6, food.getSurplusType());
                pstmt.executeUpdate();
              
            } else {
            }
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                // This SQLState indicates a unique constraint violation (e.g., primary key already exists)
                System.out.println("Food Item with ID " + food.getFoodID()+ " already exists.");
                // Handle the situation appropriately (e.g., log the error, throw an exception, etc.)
            } else {
                // Handle other SQL exceptions
                //  e.printStackTrace();
            }
        }

    }

    @Override
    public void updateFood(InventoryDTO food) {
        try {
            
            pstmt = con.prepareStatement(
                    "UPDATE User SET FoodID=? , FoodName=?, FoodAmount=?, Price=?, ExpirationDate=?, SurplusType=? ");
            pstmt.setInt(1, food.getFoodID());
            pstmt.setString(2, food.getFoodName());
            pstmt.setInt(3, food.getFoodAmount());
            pstmt.setDouble(4, food.getPrice());
            pstmt.setDate(5, food.getExpirationDate());
            pstmt.setString(6, food.getSurplusType());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFood(InventoryDTO food) {
        try {
            
            pstmt = con.prepareStatement(
                    "DELETE FROM Inventory WHERE FoodID = ?");
            pstmt.setInt(1, food.getFoodID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            try {
//                if (pstmt != null) {
//                    pstmt.close();
//                }
//
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
        }
    }
}

