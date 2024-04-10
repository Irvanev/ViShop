package com.example.petproject.dtos.brands;

public class AddBrandDto {
    private String name;
    protected AddBrandDto() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
