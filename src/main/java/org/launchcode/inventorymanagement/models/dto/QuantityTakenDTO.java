package org.launchcode.inventorymanagement.models.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class QuantityTakenDTO {
    @NotNull
    @NotBlank
    private String quantity;

    @NotNull
    @NotBlank
    private String Id;

    @NotNull
    @NotBlank
    private String quantityTaken;


    public String getQuantityTaken() {
        return quantityTaken;
    }

    public void setQuantityTaken(String quantityTaken) {
        this.quantityTaken = quantityTaken;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }




    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }



}
