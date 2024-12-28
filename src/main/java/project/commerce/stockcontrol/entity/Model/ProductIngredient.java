package project.commerce.stockcontrol.entity.Model;

import jakarta.persistence.Column;

public class ProductIngredient {

    @Column(name = "ingredient_id", nullable = false)
    private Long ingredientId;

    @Column(name = "quantity", nullable = false)
    private double quantity;

    public ProductIngredient(Long ingredientId, double quantity) {
        this.ingredientId = ingredientId;
        this.quantity = quantity;
    }


    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
