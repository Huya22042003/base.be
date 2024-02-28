package com.example.corebase.core.superAdmin.premiumManagement.service.impl;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.premiumManagement.model.request.PremiumTypeFilterRequest;
import com.example.corebase.core.superAdmin.premiumManagement.repository.PremiumManagementRepository;
import com.example.corebase.core.superAdmin.premiumManagement.service.PremiumManagementService;
import com.example.corebase.entity.PremiumTypes;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("premiumManagementService")
public class PremiumManagementServiceImpl implements PremiumManagementService {

    @Autowired
    @Qualifier("premiumManagementRepository")
    private PremiumManagementRepository repository;

    @Override
    public PageableObject<PremiumTypes> getAllPremiumType(PremiumTypeFilterRequest request) {
        return new PageableObject<>(repository.findAllByCodeContainingAndNameContaining(request.getCode(), request.getName(), request.getPageable()));
    }

    @Override
    public PremiumTypes createPremiumType(PremiumTypes premiumTypes) {
        return repository.save(premiumTypes);
    }

    @Override
    public PremiumTypes updatePremiumType(PremiumTypes premiumTypes) {
        return repository.save(premiumTypes);
    }

    @Override
    public PremiumTypes deletePremiumType(Long id) {
        PremiumTypes premiumTypes = repository.findById(id).get();
        premiumTypes.setIsActive(ActiveStatus.NOT_ACTIVE);
        return repository.save(premiumTypes);
    }
}
