package com.example.petproject.services.impl;

import com.example.petproject.dtos.subCategories.AddSubCategoryDto;
import com.example.petproject.dtos.subCategories.SubCategoryDto;
import com.example.petproject.models.entities.SubCategory;
import com.example.petproject.repositories.CategoryRepository;
import com.example.petproject.repositories.SubCategoryRepository;
import com.example.petproject.services.SubCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private ModelMapper modelMapper;
    private SubCategoryRepository subCategoryRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper, SubCategoryRepository subCategoryRepository, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<SubCategoryDto> allSubCategories() {
        return subCategoryRepository.findAll().stream()
                .map(subCategory -> modelMapper.map(subCategory, SubCategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addSubCategory(AddSubCategoryDto addSubCategoryDto) {
        addSubCategoryDto.setCreated(LocalDateTime.now());
        addSubCategoryDto.setModified(LocalDateTime.now());
        SubCategory subCategory = modelMapper.map(addSubCategoryDto, SubCategory.class);
        subCategory.setCategory(categoryRepository.findByName(addSubCategoryDto.getCategory()).orElse(null));
        subCategoryRepository.saveAndFlush(subCategory);
    }

    @Override
    public void deleteSubCategory(UUID id) {
        subCategoryRepository.deleteById(id);
    }

    @Override
    public void updateSubCategory(UUID id, SubCategoryDto subCategory) {
        SubCategory existingCategory = subCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("SubCategory not found"));
        existingCategory.setName(subCategory.getName());
        existingCategory.setModified(LocalDateTime.now());
        subCategoryRepository.save(existingCategory);
    }

}
