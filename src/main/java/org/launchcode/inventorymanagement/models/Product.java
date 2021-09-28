package org.launchcode.inventorymanagement.models;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.launchcode.inventorymanagement.models.data.ProductRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product extends AbstractEntity{

    @NotNull
    @Size(min=3, max=50)
    private String name;
    private String currentQuantity;
    private String replenishQuantity;
    private String quantity;
    private String safetyStock;
    private String quantityTaken;

    public Product() {
    }


    // Initialize the id and value fields.
    public Product(String aName, String Quantity, String safetyStock, String currentQuantity, String replenishQuantity,String quantityTaken) {
        super();
        this.name = aName;
        this.quantity = Quantity;
        this.safetyStock = safetyStock;
        this.currentQuantity = currentQuantity;
        this.replenishQuantity = replenishQuantity;
        this.quantityTaken = quantityTaken;

    }



    // Getters and setters.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(String safetyStock) {
        this.safetyStock = safetyStock;
    }

    public String getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(String currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public String getReplenishQuantity() {
        return replenishQuantity;
    }

    public void setReplenishQuantity(String replenishQuantity) {
        this.replenishQuantity = replenishQuantity;
    }

    public String getQuantityTaken() {
        return quantityTaken;
    }

    public void setQuantityTaken(String quantityTaken) {
        this.quantityTaken = quantityTaken;
    }

    @Override
    public String toString() {
        return name;
    }


}