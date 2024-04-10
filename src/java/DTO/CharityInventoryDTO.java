package DTO;

import java.util.Date;

/**
 * Data Transfer Object (DTO) representing Charity Inventory.
 */
public class CharityInventoryDTO {
    private Integer inventoryID; // The inventory ID
    private Integer charityID; // The charity ID
    private Integer quantity; // The quantity
    private String foodName; // The name of the food
    private Date expirationDate; // The expiration date
    private Date itemAdded; // The date when the item was added

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
     * Retrieves the charity ID.
     *
     * @return the charity ID
     */
    public Integer getCharityID() {
        return charityID;
    }

    /**
     * Sets the charity ID.
     *
     * @param charityID the charity ID to set
     */
    public void setCharityID(Integer charityID) {
        this.charityID = charityID;
    }

    /**
     * Retrieves the quantity.
     *
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity.
     *
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
     * Retrieves the expiration date.
     *
     * @return the expiration date
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the expiration date.
     *
     * @param expirationDate the expiration date to set
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    /**
     * Retrieves the date when the item was added.
     *
     * @return the date when the item was added
     */
    public Date getItemAdded() {
        return itemAdded;
    }

    /**
     * Sets the date when the item was added.
     *
     * @param itemAdded the date when the item was added
     */
    public void setItemAdded(Date itemAdded) {
        this.itemAdded = itemAdded;
    }
}
