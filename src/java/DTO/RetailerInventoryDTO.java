package DTO;

import java.util.Date;

/**
 *
 * @author Aaref
 */
public class RetailerInventoryDTO {
    private Integer InventoryID;
    private Integer UserID;
    private Integer FoodID;
    private Integer FoodAmount;
    private Double Price;
    private Date ExpirationDate;
    private String SurplusType;

    public Integer getInventoryID() {
        return InventoryID;
    }

    public void setInventoryID(Integer InventoryID) {
        this.InventoryID = InventoryID;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer UserID) {
        this.UserID = UserID;
    }

    public Integer getFoodID() {
        return FoodID;
    }

    public void setFoodID(Integer FoodID) {
        this.FoodID = FoodID;
    }

    public Integer getFoodAmount() {
        return FoodAmount;
    }

    public void setFoodAmount(Integer FoodAmount) {
        this.FoodAmount = FoodAmount;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
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
