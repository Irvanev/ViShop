package com.example.petproject.controllers;

import com.example.petproject.dtos.products.AddProductDto;
import com.example.petproject.dtos.products.ProductDetailDto;
import com.example.petproject.dtos.products.ProductDto;
import com.example.petproject.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@Tag(name="Controller for products", description="requests for categories")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    @Operation(
            summary = "Get all products",
            description = "Get all products from the database"
    )
    Iterable<ProductDto> getAllProducts() {
        return productService.allProducts();
    }

    @PostMapping("/add")
    @Operation(
            summary = "Adding a new product",
            description = "Adding a new product to the database"
    )
    void addProduct(@RequestBody AddProductDto addProductDto) {
        productService.addProduct(addProductDto);
    }

    @GetMapping("/{slug}")
    public ResponseEntity<ProductDetailDto> getProductBySlug(@PathVariable String slug) {
        return productService.findBySlug(slug)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
