package com.example.petproject.dtos.subCategories;

import com.example.petproject.dtos.categories.CategoryDto;
import java.time.LocalDateTime;
import java.util.UUID;

public class SubCategoryDto {
    private UUID id;
    private String category;
    private String name;
    private LocalDateTime created;
    private LocalDateTime modified;

    protected SubCategoryDto() {};

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
