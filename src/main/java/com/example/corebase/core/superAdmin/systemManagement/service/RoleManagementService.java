package com.example.corebase.core.superAdmin.systemManagement.service;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.RolesManagementFilterRequest;
import com.example.corebase.entity.RolesEntity;

public interface RoleManagementService {
    PageableObject<RolesEntity> getListRoles(RolesManagementFilterRequest request);
    RolesEntity addRoles(RolesEntity rolesEntity);
    RolesEntity updateRoles(RolesEntity rolesEntity);
    RolesEntity deleteRoles(Long id);
}
