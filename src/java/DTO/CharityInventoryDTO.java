package DTO;

import java.util.Date;

/**
 * Represents an item in the inventory of a charity organization.
 */
public class CharityInventoryDTO {
    private Integer inventoryID;
    private Integer charityID;
    private Integer quantity;
    private String foodName;
    private Date expirationDate;
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
     * Retrieves the ID of the charity associated with the inventory item.
     *
     * @return The ID of the charity associated with the inventory item.
     */
    public Integer getCharityID() {
        return charityID;
    }

    /**
     * Sets the ID of the charity associated with the inventory item.
     *
     * @param charityID The ID of the charity associated with the inventory item.
     */
    public void setCharityID(Integer charityID) {
        this.charityID = charityID;
    }

    /**
     * Retrieves the quantity of the inventory item.
     *
     * @return The quantity of the inventory item.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the inventory item.
     *
     * @param quantity The quantity of the inventory item.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
