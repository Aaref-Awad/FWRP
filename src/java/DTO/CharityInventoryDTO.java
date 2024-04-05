package DTO;

/**
 *
 * @author Aaref
 */
public class CharityInventoryDTO {
    private Integer InventoryID;
    private Integer CharityID;
    private Integer FoodID;
    private Integer Quantity;

    public Integer getInventoryID() {
        return InventoryID;
    }

    public void setInventoryID(Integer InventoryID) {
        this.InventoryID = InventoryID;
    }

    public Integer getCharityID() {
        return CharityID;
    }

    public void setCharityID(Integer CharityID) {
        this.CharityID = CharityID;
    }

    public Integer getFoodID() {
        return FoodID;
    }

    public void setFoodID(Integer FoodID) {
        this.FoodID = FoodID;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }
}
