package com.example.corebase.core.superAdmin.systemManagement.service;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuRolesManagementFilterRequest;
import com.example.corebase.entity.RolesEntity;

public interface SuRoleManagementService {
    PageableObject<RolesEntity> getListRoles(SuRolesManagementFilterRequest request);
    RolesEntity addRoles(RolesEntity rolesEntity);
    RolesEntity updateRoles(RolesEntity rolesEntity);
    RolesEntity deleteRoles(Long id);
    RolesEntity detailRoles(Long id);
}
