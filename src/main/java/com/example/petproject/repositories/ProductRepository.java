package com.example.petproject.repositories;

import com.example.petproject.models.entities.Category;
import com.example.petproject.models.entities.Products;
import com.example.petproject.models.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Products, UUID> {
    List<Products> findBySubCategory(SubCategory subCategory);
    List<Products> findBySubCategoryAndPriceBetween(SubCategory subCategory, double min, double max);
    Optional<Products> findBySlug(String slug);
}
