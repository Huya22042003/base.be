package com.example.corebase.core.superAdmin.systemManagement.service;

import com.example.corebase.core.superAdmin.systemManagement.model.response.MenuLoginResponseImpl;

import java.util.List;

public interface SuMenuManagementService {
    List<MenuLoginResponseImpl> getMenuLogin();
}
