package com.example.corebase.core.superAdmin.systemManagement.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.service.SuObjectManagementService;
import com.example.corebase.entity.ObjectsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/super-admin/object-management")
public class ObjectManagementController {

    @Autowired
    @Qualifier("objectManagementServiceImpl")
    private SuObjectManagementService service;

    @GetMapping
    public ResponseObject getAllObjectManagement(SuObjectManagementFilterRequest request) {
        return new ResponseObject(service.getAllObjects(request));
    }

    @PostMapping
    public ResponseObject createOrUpdateObjectManagement(ObjectsEntity objectsEntity) {
        return new ResponseObject(service.createOrUpdateObjects(objectsEntity));
    }
}
