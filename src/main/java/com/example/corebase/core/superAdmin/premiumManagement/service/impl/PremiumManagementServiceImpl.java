package com.example.corebase.core.superAdmin.premiumManagement.service.impl;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.premiumManagement.model.request.PremiumTypeFilterRequest;
import com.example.corebase.core.superAdmin.premiumManagement.repository.PremiumManagementRepository;
import com.example.corebase.core.superAdmin.premiumManagement.service.PremiumManagementService;
import com.example.corebase.entity.PremiumTypesEntity;
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
    public PageableObject<PremiumTypesEntity> getAllPremiumType(PremiumTypeFilterRequest request) {
        return new PageableObject<>(repository.findAllByCodeContainingAndNameContaining(request.getCode(), request.getName(), null));
    }

    @Override
    public PremiumTypesEntity createPremiumType(PremiumTypesEntity premiumTypesEntity) {
        return repository.save(premiumTypesEntity);
    }

    @Override
    public PremiumTypesEntity updatePremiumType(PremiumTypesEntity premiumTypesEntity) {
        return repository.save(premiumTypesEntity);
    }

    @Override
    public PremiumTypesEntity deletePremiumType(Long id) {
        PremiumTypesEntity premiumTypesEntity = repository.findById(id).get();
        premiumTypesEntity.setIsActive(ActiveStatus.NOT_ACTIVE);
        return repository.save(premiumTypesEntity);
    }
}
