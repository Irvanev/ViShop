package com.example.petproject.repositories;

import com.example.petproject.models.entities.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brands, UUID> {
    Optional<Brands> findByName(String name);
}
