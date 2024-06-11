package com.example.petproject.services.impl;

import com.example.petproject.dtos.categories.CategoryDto;
import com.example.petproject.models.entities.Category;
import com.example.petproject.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setup() {
        Category category1 = new Category();
        category1.setName("Category 1");

        Category category2 = new Category();
        category2.setName("Category 2");

        CategoryDto categoryDto1 = new CategoryDto("Category 1");
        CategoryDto categoryDto2 = new CategoryDto("Category 2");

        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category1, category2));
        when(modelMapper.map(category1, CategoryDto.class)).thenReturn(categoryDto1);
        when(modelMapper.map(category2, CategoryDto.class)).thenReturn(categoryDto2);
    }

    @Test
    public void testAllCategories() {
        List<CategoryDto> categories = (List<CategoryDto>) categoryService.allCategories();

        assertEquals(2, categories.size());
        assertEquals("Category 1", categories.get(0).getName());
        assertEquals("Category 2", categories.get(1).getName());
    }
}
