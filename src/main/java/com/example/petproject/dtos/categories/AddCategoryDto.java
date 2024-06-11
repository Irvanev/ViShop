package com.example.petproject.dtos.categories;

public class AddCategoryDto {
    private String name;
    protected AddCategoryDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
