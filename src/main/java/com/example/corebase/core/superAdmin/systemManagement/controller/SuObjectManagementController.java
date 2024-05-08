package com.example.corebase.core.superAdmin.systemManagement.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.service.SuObjectManagementService;
import com.example.corebase.entity.ObjectsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/super-admin/object-management")
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

    @DeleteMapping
    public ResponseObject deleteObjectManagement(@RequestParam(name = "id") Long id) {
        return new ResponseObject(service.deleteObjects(id));
    }
}
