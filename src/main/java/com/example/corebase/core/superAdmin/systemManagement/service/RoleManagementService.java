package com.example.corebase.core.superAdmin.systemManagement.service;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.RolesManagementFilterRequest;
import com.example.corebase.entity.Roles;

public interface RoleManagementService {
    PageableObject<Roles> getListRoles(RolesManagementFilterRequest request);
    Roles addRoles(Roles roles);
    Roles updateRoles(Roles roles);
    Roles deleteRoles(Long id);
}
