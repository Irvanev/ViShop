package com.example.petproject.services;

import com.example.petproject.dtos.products.AddProductDto;
import com.example.petproject.dtos.products.ProductDetailDto;
import com.example.petproject.dtos.products.ProductDto;
import com.example.petproject.dtos.subCategories.SubCategoryDto;
import com.example.petproject.models.entities.SubCategory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    Iterable<ProductDto> allProducts();
    void addProduct(AddProductDto addProductDto);
    ProductDto updateProduct(ProductDto updateProductDto);
    void deleteProduct(UUID productId);
    List<ProductDto> findBySubCategory(SubCategory subCategoryDto);
    Optional<ProductDetailDto> findBySlug(String slug);
}
