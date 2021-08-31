package org.launchcode.inventorymanagement.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product extends AbstractEntity{

    @NotNull
    @Size(min=3, max=50)
    private String name;

    private String employer;
    private String skill;

    public Product() {
    }

    // Initialize the id and value fields.
    public Product(String aName, String anEmployer, String someSkill) {
        super();
        this.name = aName;
        this.employer = anEmployer;
        this.skill = someSkill;
    }

    // Getters and setters.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return name;
    }
}