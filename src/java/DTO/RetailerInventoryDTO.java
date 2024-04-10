package DTO;

import java.util.Date;

/**
 * Data Transfer Object (DTO) representing Retailer Inventory.
 */
public class RetailerInventoryDTO {
    private Integer inventoryID; // The inventory ID
    private Integer userID; // The user ID associated with the inventory
    private String foodName; // The name of the food
    private Integer foodAmount; // The amount of food
    private Double price; // The price of the food
    private Date expirationDate; // The expiration date of the food
    private String surplusType; // The type of surplus
    private Date itemAdded; // The date the item was added

    /**
     * Retrieves the inventory ID.
     *
     * @return the inventory ID
     */
    public Integer getInventoryID() {
        return inventoryID;
    }

    /**
     * Sets the inventory ID.
     *
     * @param inventoryID the inventory ID to set
     */
    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    /**
     * Retrieves the user ID associated with the inventory.
     *
     * @return the user ID
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Sets the user ID associated with the inventory.
     *
     * @param userID the user ID to set
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * Retrieves the name of the food.
     *
     * @return the food name
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * Sets the name of the food.
     *
     * @param foodName the food name to set
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * Retrieves the amount of food.
     *
     * @return the food amount
     */
    public Integer getFoodAmount() {
        return foodAmount;
    }

    /**
     * Sets the amount of food.
     *
     * @param foodAmount the food amount to set
     */
    public void setFoodAmount(Integer foodAmount) {
        this.foodAmount = foodAmount;
    }

    /**
     * Retrieves the price of the food.
     *
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price of the food.
     *
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Retrieves the expiration date of the food.
     *
     * @return the expiration date
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the expiration date of the food.
     *
     * @param expirationDate the expiration date to set
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Retrieves the surplus type.
     *
     * @return the surplus type
     */
    public String getSurplusType() {
        return surplusType;
    }

    /**
     * Sets the surplus type.
     *
     * @param surplusType the surplus type to set
     */
    public void setSurplusType(String surplusType) {
        this.surplusType = surplusType;
    }

    /**
     * Retrieves the date the item was added.
     *
     * @return the item added date
     */
    public Date getItemAdded() {
        return itemAdded;
    }

    /**
     * Sets the date the item was added.
     *
     * @param itemAdded the item added date to set
     */
    public void setItemAdded(Date itemAdded) {
        this.itemAdded = itemAdded;
    }
}
