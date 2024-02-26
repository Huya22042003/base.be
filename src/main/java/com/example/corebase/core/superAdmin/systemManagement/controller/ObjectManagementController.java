package com.example.corebase.core.superAdmin.systemManagement.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.ObjectManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.service.ObjectManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/super-admin/object-management")
public class ObjectManagementController {

    @Autowired
    @Qualifier("objectManagementServiceImpl")
    private ObjectManagementService service;

    @GetMapping("/")
    public ResponseObject getAllObjectManagement(ObjectManagementFilterRequest request) {
        return new ResponseObject(service.getAllObjects(request));
    }
}
