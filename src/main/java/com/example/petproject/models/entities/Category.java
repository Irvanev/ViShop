package com.example.petproject.models.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category extends BaseEntity {
    private List<SubCategory> subCategories;
    private String name;

    public Category() {};

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.REMOVE)
    public List<SubCategory> getSubCategories() {
        return subCategories;
    }
    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
