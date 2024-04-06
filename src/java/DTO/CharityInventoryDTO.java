package DTO;

import java.util.Date;

/**
 * DTO for Charity Inventory
 */
public class CharityInventoryDTO {
    private Integer inventoryID;
    private Integer charityID;
    private Integer quantity;
    private String foodName;
    private Date expirationDate;

    public Integer getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Integer getCharityID() {
        return charityID;
    }

    public void setCharityID(Integer charityID) {
        this.charityID = charityID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}