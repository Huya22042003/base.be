package com.example.corebase.core.superAdmin.systemManagement.service;

import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuLoginResponse;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuLoginResponseImpl;

import java.util.List;
import java.util.UUID;

public interface SuMenuManagementService {
    List<SuMenuLoginResponseImpl> getMenuLogin();

    List<SuMenuLoginResponseImpl> menuReturn(List<SuMenuLoginResponse> menuLoginRepository);

    List<SuMenuLoginResponseImpl> buildRootMenuTree(List<SuMenuLoginResponse> menuList);

    List<SuMenuLoginResponseImpl> buildNotRootMenuTree(List<SuMenuLoginResponse> menuList);

    List<SuMenuLoginResponseImpl> buildSubMenuTree(UUID parentId, List<SuMenuLoginResponseImpl> objectsList);
}
