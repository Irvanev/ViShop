package com.example.petproject.repositories;

import com.example.petproject.models.entities.Roles;
import com.example.petproject.models.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Roles, UUID> {
    Optional<Roles> findByRoleName(RoleEnum role);
}
