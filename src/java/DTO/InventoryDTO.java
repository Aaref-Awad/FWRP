/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Owner
 */
public class InventoryDTO {
    private Integer FoodID;
    private String FoodName;
    private Integer FoodAmount;
    private double Price;
    private Date ExpirationDate;
    private String SurplusType;

    public Integer getFoodID() {
        return FoodID;
    }

    public void setFoodID(Integer FoodID) {
        this.FoodID = FoodID;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String FoodName) {
        this.FoodName = FoodName;
    }

    public Integer getFoodAmount() {
        return FoodAmount;
    }

    public void setFoodAmount(Integer FoodAmount) {
        this.FoodAmount = FoodAmount;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public Date getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(Date ExpirationDate) {
        this.ExpirationDate = ExpirationDate;
    }

    public String getSurplusType() {
        return SurplusType;
    }

    public void setSurplusType(String SurplusType) {
        this.SurplusType = SurplusType;
    }
}
