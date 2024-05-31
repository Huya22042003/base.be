package com.example.corebase.repository;

import com.example.corebase.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, UUID> {
    static final String BASE_NAME = "roles_repository";
}
