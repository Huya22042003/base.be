package com.example.corebase.core.superAdmin.informationManagement.service;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.informationManagement.model.request.SuObjectGroupFilterRequest;
import com.example.corebase.core.superAdmin.informationManagement.model.request.SuPremiumTypeCreateRequest;
import com.example.corebase.core.superAdmin.informationManagement.model.request.SuPremiumTypeFilterRequest;
import com.example.corebase.core.superAdmin.informationManagement.model.response.SuObjectGroupAddResponse;
import com.example.corebase.core.superAdmin.informationManagement.model.response.SuPremiumManagementResponse;
import com.example.corebase.entity.PremiumTypesEntity;
import com.example.corebase.util.SimpleObjectResponse;

import java.util.List;
import java.util.UUID;

public interface SuPremiumManagementService {
    PageableObject<SuPremiumManagementResponse> getAllPremiumType(SuPremiumTypeFilterRequest request);

    PremiumTypesEntity createPremiumType(SuPremiumTypeCreateRequest premiumTypesEntity);

    PremiumTypesEntity updatePremiumType(SuPremiumTypeCreateRequest premiumTypesEntity);

    PremiumTypesEntity deletePremiumType(UUID id);

    List<SimpleObjectResponse> getListRoles();

    PageableObject<SuObjectGroupAddResponse> getAllObjectGroup(SuObjectGroupFilterRequest request);
}
