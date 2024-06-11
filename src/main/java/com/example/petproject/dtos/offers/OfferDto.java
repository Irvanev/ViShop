package com.example.petproject.dtos.offers;

import com.example.petproject.dtos.products.ProductDto;
import com.example.petproject.dtos.users.UserDto;
import com.example.petproject.models.enums.OfferEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public class OfferDto {
    private UUID id;
    private ProductDto productDto;
    private UserDto userDto;
    private OfferEnum status;
    private LocalDateTime created;
    private LocalDateTime modified;

    protected OfferDto() {};

    public OfferDto(ProductDto productDto, UserDto userDto, OfferEnum status) {
        this.productDto = productDto;
        this.userDto = userDto;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public OfferEnum getStatus() {
        return status;
    }

    public void setStatus(OfferEnum status) {
        this.status = status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
