package com.example.corebase.core.superAdmin.premiumManagement.service;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.premiumManagement.model.request.PremiumTypeFilterRequest;
import com.example.corebase.entity.PremiumTypes;

public interface PremiumManagementService {
    PageableObject<PremiumTypes> getAllPremiumType(PremiumTypeFilterRequest request);
    PremiumTypes createPremiumType(PremiumTypes premiumTypes);
    PremiumTypes updatePremiumType(PremiumTypes premiumTypes);
    PremiumTypes deletePremiumType(Long id);
}
