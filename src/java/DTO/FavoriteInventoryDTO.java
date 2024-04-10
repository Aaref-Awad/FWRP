package DTO;

/**
 * Data Transfer Object (DTO) representing Favorite Inventory.
 */
public class FavoriteInventoryDTO {
    private Integer favoriteID; // The favorite ID
    private Integer userID; // The user ID associated with the favorite
    private Integer inventoryID; // The inventory ID associated with the favorite
    private String foodName; // The name of the food
    private String retailerName; // The name of the retailer

    /**
     * Retrieves the favorite ID.
     *
     * @return the favorite ID
     */
    public Integer getFavoriteID() {
        return favoriteID;
    }

    /**
     * Sets the favorite ID.
     *
     * @param favoriteID the favorite ID to set
     */
    public void setFavoriteID(Integer favoriteID) {
        this.favoriteID = favoriteID;
    }

    /**
     * Retrieves the user ID associated with the favorite.
     *
     * @return the user ID
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Sets the user ID associated with the favorite.
     *
     * @param userID the user ID to set
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * Retrieves the inventory ID associated with the favorite.
     *
     * @return the inventory ID
     */
    public Integer getInventoryID() {
        return inventoryID;
    }

    /**
     * Sets the inventory ID associated with the favorite.
     *
     * @param inventoryID the inventory ID to set
     */
    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
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
     * Retrieves the name of the retailer.
     *
     * @return the retailer name
     */
    public String getRetailerName() {
        return retailerName;
    }

    /**
     * Sets the name of the retailer.
     *
     * @param retailerName the retailer name to set
     */
    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }
}
