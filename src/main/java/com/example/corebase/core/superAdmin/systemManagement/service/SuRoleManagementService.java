package com.example.corebase.core.superAdmin.systemManagement.service;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuRolesManagementDetailRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuRolesManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuRolesManagementRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuLoginResponseImpl;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuRolesManagementResponse;
import com.example.corebase.entity.RolesEntity;

import java.util.List;

public interface SuRoleManagementService {
    PageableObject<SuRolesManagementResponse> getListRoles(SuRolesManagementFilterRequest request);
    List<SuMenuLoginResponseImpl> getMenuLogin();
    RolesEntity addRoles(SuRolesManagementRequest request);
    RolesEntity updateRoles(SuRolesManagementRequest request);
    RolesEntity deleteRoles(Long id);
    SuRolesManagementDetailRequest detailRoles(Long id);
}
