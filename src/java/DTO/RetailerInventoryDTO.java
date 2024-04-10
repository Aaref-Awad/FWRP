package DTO;

import java.util.Date;

/**
 *
 * DTO for Retailer Inventory
 */
public class RetailerInventoryDTO {
    private Integer inventoryID;
    private Integer userID;
    private String foodName;
    private Integer foodAmount;
    private Double price;
    private Date expirationDate;
    private String surplusType;
    private Date itemAdded; // Added attribute

    public Integer getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(Integer foodAmount) {
        this.foodAmount = foodAmount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSurplusType() {
        return surplusType;
    }

    public void setSurplusType(String surplusType) {
        this.surplusType = surplusType;
    }
    
    public Date getItemAdded() {
        return itemAdded;
    }

    public void setItemAdded(Date itemAdded) {
        this.itemAdded = itemAdded;
    }
}
