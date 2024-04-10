package com.example.petproject.utils;

import com.example.petproject.dtos.brands.BrandDto;
import com.example.petproject.dtos.categories.CategoryDto;
import com.example.petproject.dtos.products.ProductDto;
import com.example.petproject.dtos.subCategories.SubCategoryDto;
import com.example.petproject.models.entities.Roles;
import com.example.petproject.models.enums.RoleEnum;
import com.example.petproject.repositories.RoleRepository;
import com.example.petproject.services.BrandService;
import com.example.petproject.services.CategoryService;
import com.example.petproject.services.ProductService;
import com.example.petproject.services.SubCategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Data implements CommandLineRunner {
    private final BrandService brandService;
    private final CategoryService categoryService;
    private final SubCategoryService subCategoryService;
    private final ProductService productService;
    private final RoleRepository roleRepository;

    public Data(BrandService brandService, CategoryService categoryService, SubCategoryService subCategoryService,
                ProductService productService, RoleRepository roleRepository) {
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
        this.productService = productService;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        //seedData();
    }


}
