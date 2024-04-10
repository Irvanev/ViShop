package com.example.petproject.services.impl;

import com.example.petproject.dtos.products.AddProductDto;
import com.example.petproject.dtos.products.ProductDetailDto;
import com.example.petproject.dtos.products.ProductDto;
import com.example.petproject.dtos.subCategories.SubCategoryDto;
import com.example.petproject.models.entities.Products;
import com.example.petproject.models.entities.SubCategory;
import com.example.petproject.repositories.BrandRepository;
import com.example.petproject.repositories.ProductRepository;
import com.example.petproject.repositories.SubCategoryRepository;
import com.example.petproject.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final SubCategoryRepository subCategoryRepository;

    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository,
                              BrandRepository brandRepository, SubCategoryRepository subCategoryRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public List<ProductDto> allProducts() {
        return productRepository.findAll().stream().map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addProduct(AddProductDto addProductDto) {
        addProductDto.setCreated(LocalDateTime.now());
        addProductDto.setModified(LocalDateTime.now());
        Products products = modelMapper.map(addProductDto, Products.class);
        products.setSubCategory(subCategoryRepository.findByName(addProductDto.getSubCategory()).orElse(null));
        products.setBrand(brandRepository.findByName(addProductDto.getBrand()).orElse(null));
        productRepository.saveAndFlush(products);
    }

    @Override
    public ProductDto updateProduct(ProductDto updateProductDto) {
        Products products = modelMapper.map(updateProductDto, Products.class);
        products.setModified(LocalDateTime.now());
        return modelMapper.map(productRepository.saveAndFlush(products), ProductDto.class);
    }

    @Override
    public void deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<ProductDto> findBySubCategory(SubCategory subCategoryDto) {
        return productRepository.findBySubCategory(subCategoryDto).stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<ProductDetailDto> findBySlug(String slug) {
        return productRepository.findBySlug(slug).map(product -> modelMapper.map(product, ProductDetailDto.class));
    }
}
