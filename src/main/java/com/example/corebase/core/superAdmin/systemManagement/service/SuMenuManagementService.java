package com.example.corebase.core.superAdmin.systemManagement.service;

import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuLoginResponseImpl;

import java.util.List;

public interface SuMenuManagementService {
    List<SuMenuLoginResponseImpl> getMenuLogin();
}
