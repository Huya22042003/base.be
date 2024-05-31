package com.example.corebase.core.superAdmin.informationManagement.service.impl;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.informationManagement.model.request.SuPremiumTypeCreateRequest;
import com.example.corebase.core.superAdmin.informationManagement.model.request.SuPremiumTypeFilterRequest;
import com.example.corebase.core.superAdmin.informationManagement.model.response.SuPremiumManagementResponse;
import com.example.corebase.core.superAdmin.informationManagement.repository.SuPremiumManagementRepository;
import com.example.corebase.core.superAdmin.informationManagement.service.SuPremiumManagementService;
import com.example.corebase.entity.PremiumTypesEntity;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import com.example.corebase.repository.RolesRepository;
import com.example.corebase.util.PageableCommon;
import com.example.corebase.util.SimpleObjectResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("premiumManagementService")
public class SuPremiumManagementServiceImpl implements SuPremiumManagementService {

    @Autowired
    @Qualifier("premiumManagementRepository")
    private SuPremiumManagementRepository repository;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public PageableObject<SuPremiumManagementResponse> getAllPremiumType(SuPremiumTypeFilterRequest request) {
        return new PageableObject<>(repository.getPagePremiumManagement(request, PageableCommon.getPageable(request)));
    }

    @Override
    @Transactional
    public PremiumTypesEntity createPremiumType(SuPremiumTypeCreateRequest premiumTypesEntity) {
        PremiumTypesEntity entity = new PremiumTypesEntity();

        entity.setCode(premiumTypesEntity.getCode());
        entity.setName(premiumTypesEntity.getName());
        entity.setLevel(premiumTypesEntity.getLevel());
        entity.setRolesEntityId(rolesRepository.findById(premiumTypesEntity.getRoleId()).orElse(null));
        entity.setMoney(premiumTypesEntity.getMoney());
        entity.setNote(premiumTypesEntity.getNote());
        entity.setStatus(premiumTypesEntity.getStatus());

        return repository.save(entity);
    }

    @Override
    @Transactional
    public PremiumTypesEntity updatePremiumType(SuPremiumTypeCreateRequest premiumTypesEntity) {
        PremiumTypesEntity entity = new PremiumTypesEntity();

        entity.setId(premiumTypesEntity.getId());
        entity.setCode(premiumTypesEntity.getCode());
        entity.setName(premiumTypesEntity.getName());
        entity.setLevel(premiumTypesEntity.getLevel());
        entity.setRolesEntityId(rolesRepository.findById(premiumTypesEntity.getRoleId()).orElse(null));
        entity.setMoney(premiumTypesEntity.getMoney());
        entity.setNote(premiumTypesEntity.getNote());
        entity.setStatus(premiumTypesEntity.getStatus());

        return repository.save(entity);
    }

    @Override
    public PremiumTypesEntity deletePremiumType(UUID id) {
        PremiumTypesEntity premiumTypesEntity = repository.findById(id).get();
        premiumTypesEntity.setIsActive(ActiveStatus.NOT_ACTIVE);
        return repository.save(premiumTypesEntity);
    }

    @Override
    public List<SimpleObjectResponse> getListRoles() {
        return repository.getAllRolesActive();
    }
}
