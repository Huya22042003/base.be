package com.example.corebase.core.superAdmin.premiumManagement.service;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.premiumManagement.model.request.PremiumTypeFilterRequest;
import com.example.corebase.entity.PremiumTypesEntity;

public interface PremiumManagementService {
    PageableObject<PremiumTypesEntity> getAllPremiumType(PremiumTypeFilterRequest request);
    PremiumTypesEntity createPremiumType(PremiumTypesEntity premiumTypesEntity);
    PremiumTypesEntity updatePremiumType(PremiumTypesEntity premiumTypesEntity);
    PremiumTypesEntity deletePremiumType(Long id);
}
