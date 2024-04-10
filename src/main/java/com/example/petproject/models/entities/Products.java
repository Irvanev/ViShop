package com.example.petproject.models.entities;

import com.github.slugify.Slugify;
import jakarta.persistence.*;
import java.io.IOException;
import java.util.List;

@Entity
public class Products extends BaseEntity {
    private List<Offers> offers;
    private Brands brand;
    private SubCategory subCategory;
    private String name;
    private String description;
    private double price;
    private double newPrice;
    private String imageURL;
    private String material;
    private String sim;
    private String weight;
    private int ram;
    private int memory;
    private int rate;
    private int camera;
    private double diagonal;
    private String slug;

    protected Products() {};
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products", cascade = CascadeType.REMOVE)
    public List<Offers> getOffers() {
        return offers;
    }

    public void setOffers(List<Offers> offers) {
        this.offers = offers;
    }

    @ManyToOne
    @JoinColumn(name = "brand_id")
    public Brands getBrand() {
        return brand;
    }
    public void setBrand(Brands brand) {
        this.brand = brand;
    }

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IOException {
        this.name = name;
        this.slug = new Slugify().slugify(name);
    }
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }
}
