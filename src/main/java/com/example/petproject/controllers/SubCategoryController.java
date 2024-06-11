package com.example.petproject.controllers;

import com.example.petproject.dtos.subCategories.AddSubCategoryDto;
import com.example.petproject.dtos.subCategories.SubCategoryDto;
import com.example.petproject.services.SubCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sub_categories")
public class SubCategoryController {
    private SubCategoryService subCategoryService;

    @Autowired
    public void setSubCategoryService(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping("/all")
    @Operation(
            summary = "Get all subcategories",
            description = "Get all subcategories from the database"
    )
    Iterable<SubCategoryDto> getAllSubCategories() {
        return subCategoryService.allSubCategories();
    }

    @PostMapping("/add")
    @Operation(
            summary = "Adding a new category",
            description = "Adding a new category to the database"
    )
    void addSubCategory(@RequestBody AddSubCategoryDto addSubCategoryDto) {
        subCategoryService.addSubCategory(addSubCategoryDto);
    }

}
