package com.example.petproject.dtos.subCategories;

import java.time.LocalDateTime;

public class AddSubCategoryDto {
    private String name;
    private String category;
    private LocalDateTime created;
    private LocalDateTime modified;
    protected AddSubCategoryDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
