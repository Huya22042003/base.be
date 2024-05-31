package com.example.corebase.core.superAdmin.systemManagement.service;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuModuleFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuModuleManagementRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuModuleResponse;
import com.example.corebase.entity.ModuleEntity;

import java.util.UUID;

public interface SuModuleService {
    PageableObject<SuModuleResponse> getPageModuleResponse(SuModuleFilterRequest request);
    Boolean createModuleManagement(SuModuleManagementRequest request);
    Boolean updateModuleManagement(SuModuleManagementRequest request);
    Boolean deleteModuleManagement(UUID id);
    ModuleEntity detailModuleEntity(UUID id);
}
