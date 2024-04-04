package DTO;

/**
 *
 * @author Aaref
 */
public class ConsumerInventoryDTO {
    private Integer InventoryID;
    private Integer ConsumerID;
    private Integer FoodID;
    private Integer Quantity;

    public Integer getInventoryID() {
        return InventoryID;
    }

    public void setInventoryID(Integer InventoryID) {
        this.InventoryID = InventoryID;
    }

    public Integer getConsumerID() {
        return ConsumerID;
    }

    public void setConsumerID(Integer ConsumerID) {
        this.ConsumerID = ConsumerID;
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
