package com.example.corebase.repository;

import com.example.corebase.entity.PremiumTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiumTypesRepository extends JpaRepository<PremiumTypes, Long> {
    static final String BASE_NAME = "premium_type_repository";
}
