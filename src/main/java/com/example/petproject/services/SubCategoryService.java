package com.example.petproject.services;
import com.example.petproject.dtos.subCategories.AddSubCategoryDto;
import com.example.petproject.dtos.subCategories.SubCategoryDto;

import java.util.UUID;

public interface SubCategoryService {
    Iterable<SubCategoryDto> allSubCategories();
    void addSubCategory(AddSubCategoryDto addSubCategoryDto);
    void updateSubCategory(UUID id, SubCategoryDto subCategory);
    void deleteSubCategory(UUID id);
}
