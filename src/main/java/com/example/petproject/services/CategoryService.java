package com.example.petproject.services;

import com.example.petproject.dtos.categories.CategoryDto;

import java.util.UUID;

public interface CategoryService {
    Iterable<CategoryDto> allCategories();
    CategoryDto addCategory(CategoryDto categories);
    void updateCategory(UUID id, CategoryDto category);
    void deleteCategory(UUID id);
}
