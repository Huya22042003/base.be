package com.example.corebase.core.superAdmin.systemManagement.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuMenuParentModalFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.service.SuObjectManagementService;
import com.example.corebase.entity.ObjectsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/super-admin/object-management")
public class SuObjectManagementController {

    @Autowired
    @Qualifier("objectManagementServiceImpl")
    private SuObjectManagementService service;

    @PostMapping("/list")
    public ResponseObject getAllObjectManagement(@RequestBody SuObjectManagementFilterRequest request) {
        return new ResponseObject(service.getAllObjects(request));
    }

    @GetMapping("/menu-parent")
    public ResponseObject getMenuParentModal(@RequestParam(name = "id") Long id) {
        return new ResponseObject(service.getMenuParentModal(id));
    }

    @PostMapping
    public ResponseObject createObjectManagement(@RequestBody ObjectsEntity objectsEntity) {
        return new ResponseObject(service.createOrUpdateObjects(objectsEntity));
    }

    @PutMapping
    public ResponseObject updateObjectManagement(@RequestBody ObjectsEntity objectsEntity) {
        return new ResponseObject(service.createOrUpdateObjects(objectsEntity));
    }

    @GetMapping
    public ResponseObject detailObjectManagement(@RequestParam(name = "id") Long id) {
        return new ResponseObject(service.detailObjects(id));
    }
}
