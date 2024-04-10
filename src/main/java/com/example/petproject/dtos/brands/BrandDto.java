package com.example.petproject.dtos.brands;


import java.time.LocalDateTime;
import java.util.UUID;

public class BrandDto {
    private UUID id;
    private String name;
    private LocalDateTime created;
    private LocalDateTime modified;

    protected BrandDto() {};

    public BrandDto(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
