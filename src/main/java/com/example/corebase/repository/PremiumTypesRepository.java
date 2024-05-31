package com.example.corebase.repository;

import com.example.corebase.entity.PremiumTypesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PremiumTypesRepository extends JpaRepository<PremiumTypesEntity, UUID> {
    static final String BASE_NAME = "premium_type_repository";
}
