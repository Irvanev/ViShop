package com.example.petproject.repositories;

import com.example.petproject.models.entities.Offers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfferRepository extends JpaRepository<Offers, UUID> {
}
