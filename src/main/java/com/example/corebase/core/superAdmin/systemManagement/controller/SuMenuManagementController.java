package com.example.corebase.core.superAdmin.systemManagement.controller;

import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuLoginResponseImpl;
import com.example.corebase.core.superAdmin.systemManagement.service.SuMenuManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/super-admin/menu")
public class SuMenuManagementController {

    @Autowired
    private SuMenuManagementService objectLoginService;

    @GetMapping("/get-object")
    public List<SuMenuLoginResponseImpl> getObjectLogin() {
        return objectLoginService.getMenuLogin();
    }
}
