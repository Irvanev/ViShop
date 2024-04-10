package com.example.petproject.services.impl;

import com.example.petproject.dtos.brands.BrandDto;
import com.example.petproject.models.entities.Brands;
import com.example.petproject.repositories.BrandRepository;
import com.example.petproject.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelMapper modelMapper;
    private final BrandRepository brandRepository;

    public BrandServiceImpl(ModelMapper modelMapper, BrandRepository brandRepository) {
        this.modelMapper = modelMapper;
        this.brandRepository = brandRepository;
    }

    @Override
    public BrandDto addBrand(BrandDto brand) {
        Brands brands = modelMapper.map(brand, Brands.class);
        brands.setCreated(LocalDateTime.now());
        brands.setModified(LocalDateTime.now());
            return modelMapper.map(brandRepository.saveAndFlush(brands), BrandDto.class);
    }

    @Override
    public List<BrandDto> allBrands() {
        return brandRepository.findAll().stream().map(brand -> modelMapper.map(brand, BrandDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBrand(UUID id) {
        brandRepository.deleteById(id);
    }
}
