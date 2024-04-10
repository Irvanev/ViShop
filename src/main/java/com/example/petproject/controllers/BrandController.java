package com.example.petproject.controllers;

import com.example.petproject.dtos.brands.BrandDto;
import com.example.petproject.services.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/brands")
@Tag(name="Controller for brands", description="requests for brands")
public class BrandController {

    private BrandService brandService;

    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    @Operation(
            summary = "Get all brands",
            description = "Get all brands from the database"
    )
    Iterable<BrandDto> getAllBrands() {
        return brandService.allBrands();
    }

    @PostMapping("/add")
    @Operation(
            summary = "Adding a new brand",
            description = "Adding a new brand to the database"
    )
    BrandDto addBrand(@RequestBody BrandDto brand) {
        return brandService.addBrand(brand);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Delete a brand",
            description = "Delete a brand from the database"
    )
    void deleteBrand(@PathVariable UUID id) {
        brandService.deleteBrand(id);
    }
}
