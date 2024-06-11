package com.example.petproject.dtos.products;

import com.example.petproject.dtos.brands.BrandDto;
import com.example.petproject.dtos.categories.CategoryDto;
import com.example.petproject.dtos.subCategories.SubCategoryDto;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductDto {
    private UUID id;
    private String slug;
    private String brand;
    private String subCategory;
    private String name;
    private String description;
    private double price;
    private double newPrice;
    private String imageUrl;
    private LocalDateTime created;
    private LocalDateTime modified;

    protected ProductDto() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSubCategory() {
        return subCategory;
    }
}
