package com.example.petproject.repositories;

import com.example.petproject.models.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SubCategoryRepository extends JpaRepository<SubCategory, UUID> {
    Optional<SubCategory> findByName(String name);
}
