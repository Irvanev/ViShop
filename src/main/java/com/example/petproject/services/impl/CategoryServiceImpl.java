package com.example.petproject.services.impl;

import com.example.petproject.dtos.categories.CategoryDto;
import com.example.petproject.models.entities.Category;
import com.example.petproject.repositories.CategoryRepository;
import com.example.petproject.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private ModelMapper modelMapper;
    private CategoryRepository categoryRepository;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<CategoryDto> allCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto addCategory(CategoryDto category) {
        Category categories = modelMapper.map(category, Category.class);
        categories.setCreated(LocalDateTime.now());
        categories.setModified(LocalDateTime.now());
        return modelMapper.map(categoryRepository.saveAndFlush(categories), CategoryDto.class);
    }

    @Override
    public void updateCategory(UUID id, CategoryDto category) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        existingCategory.setName(category.getName());
        existingCategory.setModified(LocalDateTime.now());
        categoryRepository.saveAndFlush(existingCategory);
    }

    @Override
    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }


}
