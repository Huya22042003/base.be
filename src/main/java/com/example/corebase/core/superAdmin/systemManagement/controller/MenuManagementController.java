package com.example.corebase.core.superAdmin.systemManagement.controller;

import com.example.corebase.core.superAdmin.systemManagement.model.response.MenuLoginResponseImpl;
import com.example.corebase.core.superAdmin.systemManagement.service.SuMenuManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/menu")
public class MenuManagementController {

    @Autowired
    @Qualifier("objectLoginService")
    private SuMenuManagementService objectLoginService;

    @GetMapping("/get-object")
    public List<MenuLoginResponseImpl> getObjectLogin() {
        return objectLoginService.getMenuLogin();
    }
}
