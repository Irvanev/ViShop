package com.example.petproject.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SubCategory extends BaseEntity {
    private List<Products> products;
    private Category category;
    private String name;

    protected SubCategory() {
    }

    ;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subCategory", cascade = CascadeType.REMOVE)
    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
