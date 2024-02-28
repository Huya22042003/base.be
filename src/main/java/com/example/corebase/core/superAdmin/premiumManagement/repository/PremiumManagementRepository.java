package com.example.corebase.core.superAdmin.premiumManagement.repository;

import com.example.corebase.entity.PremiumTypes;
import com.example.corebase.repository.PremiumTypesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository("premiumManagementRepository")
public interface PremiumManagementRepository extends PremiumTypesRepository {
    Page<PremiumTypes> findAllByCodeContainingAndNameContaining(String code, String name, Pageable pageable);
}
