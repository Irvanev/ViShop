package com.example.petproject.services;

import com.example.petproject.dtos.brands.BrandDto;

import java.util.List;
import java.util.UUID;

public interface BrandService {
    List<BrandDto> allBrands();
    BrandDto addBrand(BrandDto addBrandDto);
    void deleteBrand(UUID id);
}
