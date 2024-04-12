package DTO;

import java.util.Date;

/**
 * Represents an inventory item in a retailer's inventory.
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

    /**
     * Retrieves the ID of the inventory item.
     *
     * @return The ID of the inventory item.
     */
    public Integer getInventoryID() {
        return inventoryID;
    }

    /**
     * Sets the ID of the inventory item.
     *
     * @param inventoryID The ID of the inventory item.
     */
    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    /**
     * Retrieves the ID of the user associated with the inventory item.
     *
     * @return The ID of the user associated with the inventory item.
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Sets the ID of the user associated with the inventory item.
     *
     * @param userID The ID of the user associated with the inventory item.
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * Retrieves the name of the food item in the inventory.
     *
     * @return The name of the food item in the inventory.
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * Sets the name of the food item in the inventory.
     *
     * @param foodName The name of the food item in the inventory.
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * Retrieves the quantity of the food item in the inventory.
     *
     * @return The quantity of the food item in the inventory.
     */
    public Integer getFoodAmount() {
        return foodAmount;
    }

    /**
     * Sets the quantity of the food item in the inventory.
     *
     * @param foodAmount The quantity of the food item in the inventory.
     */
    public void setFoodAmount(Integer foodAmount) {
        this.foodAmount = foodAmount;
    }

    /**
     * Retrieves the price of the food item in the inventory.
     *
     * @return The price of the food item in the inventory.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price of the food item in the inventory.
     *
     * @param price The price of the food item in the inventory.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Retrieves the expiration date of the inventory item.
     *
     * @return The expiration date of the inventory item.
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the expiration date of the inventory item.
     *
     * @param expirationDate The expiration date of the inventory item.
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Retrieves the surplus type of the inventory item.
     *
     * @return The surplus type of the inventory item.
     */
    public String getSurplusType() {
        return surplusType;
    }

    /**
     * Sets the surplus type of the inventory item.
     *
     * @param surplusType The surplus type of the inventory item.
     */
    public void setSurplusType(String surplusType) {
        this.surplusType = surplusType;
    }

    /**
     * Retrieves the date when the item was added to the inventory.
     *
     * @return The date when the item was added to the inventory.
     */
    public Date getItemAdded() {
        return itemAdded;
    }

    /**
     * Sets the date when the item was added to the inventory.
     *
     * @param itemAdded The date when the item was added to the inventory.
     */
    public void setItemAdded(Date itemAdded) {
        this.itemAdded = itemAdded;
    }
}
