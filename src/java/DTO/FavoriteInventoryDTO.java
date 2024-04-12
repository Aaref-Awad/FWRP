package DTO;

/**
 * Represents a user's favorite inventory item.
 */
public class FavoriteInventoryDTO {
    private Integer favoriteID;
    private Integer userID;
    private Integer inventoryID; // Added attribute
    private String foodName;
    private String retailerName;

    /**
     * Retrieves the ID of the favorite inventory item.
     *
     * @return The ID of the favorite inventory item.
     */
    public Integer getFavoriteID() {
        return favoriteID;
    }

    /**
     * Sets the ID of the favorite inventory item.
     *
     * @param favoriteID The ID of the favorite inventory item.
     */
    public void setFavoriteID(Integer favoriteID) {
        this.favoriteID = favoriteID;
    }

    /**
     * Retrieves the ID of the user who added the inventory item to favorites.
     *
     * @return The ID of the user who added the inventory item to favorites.
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     * Sets the ID of the user who added the inventory item to favorites.
     *
     * @param userID The ID of the user who added the inventory item to favorites.
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     * Retrieves the ID of the inventory item marked as favorite.
     *
     * @return The ID of the inventory item marked as favorite.
     */
    public Integer getInventoryID() {
        return inventoryID;
    }

    /**
     * Sets the ID of the inventory item marked as favorite.
     *
     * @param inventoryID The ID of the inventory item marked as favorite.
     */
    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    /**
     * Retrieves the name of the food item in the favorite inventory.
     *
     * @return The name of the food item in the favorite inventory.
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * Sets the name of the food item in the favorite inventory.
     *
     * @param foodName The name of the food item in the favorite inventory.
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * Retrieves the name of the retailer associated with the favorite inventory item.
     *
     * @return The name of the retailer associated with the favorite inventory item.
     */
    public String getRetailerName() {
        return retailerName;
    }

    /**
     * Sets the name of the retailer associated with the favorite inventory item.
     *
     * @param retailerName The name of the retailer associated with the favorite inventory item.
     */
    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }
}
