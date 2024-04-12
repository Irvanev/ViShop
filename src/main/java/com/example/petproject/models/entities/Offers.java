package com.example.petproject.models.entities;

import com.example.petproject.models.enums.OfferEnum;
import jakarta.persistence.*;

@Entity
public class Offers extends BaseEntity {
    private User user;
    private Products products;
    private OfferEnum status;

    protected Offers() {};

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    public OfferEnum getStatus() {
        return status;
    }

    public void setStatus(OfferEnum status) {
        this.status = status;
    }
}
