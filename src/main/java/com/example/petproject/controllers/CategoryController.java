package com.example.petproject.controllers;

import com.example.petproject.dtos.categories.CategoryDto;
import com.example.petproject.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
@Tag(name="Controller for categories", description="requests for categories")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    @Operation(
            summary = "Get all categories",
            description = "Get all categories from the database"
    )
    Iterable<CategoryDto> getAllCategories() {
        return categoryService.allCategories();
    }

    @PostMapping("/add")
    @Operation(
            summary = "Adding a new category",
            description = "Adding a new category to the database"
    )
    CategoryDto addCategory(@RequestBody CategoryDto category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Update a category",
            description = "Update a category in the database"
    )
    void updateCategory(@PathVariable UUID id, @RequestBody CategoryDto category) {
        categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Delete a category",
            description = "Delete a category from the database"
    )
    void deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
    }

}
