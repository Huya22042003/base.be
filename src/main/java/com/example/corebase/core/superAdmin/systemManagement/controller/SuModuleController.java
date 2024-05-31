package com.example.corebase.core.superAdmin.systemManagement.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuModuleFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuModuleManagementRequest;
import com.example.corebase.core.superAdmin.systemManagement.service.SuModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/super-admin/module-management")
public class SuModuleController {

    @Autowired
    private SuModuleService service;

    @PostMapping("/list")
    public ResponseObject getPageModule(@RequestBody SuModuleFilterRequest suModuleFilterRequest) {
        return new ResponseObject(service.getPageModuleResponse(suModuleFilterRequest));
    }

    @GetMapping
    public ResponseObject getDetailModule(@RequestParam(name = "id") UUID id) {
        return new ResponseObject(service.detailModuleEntity(id));
    }

    @PostMapping
    public ResponseObject createModule(@RequestBody SuModuleManagementRequest request) {
        return new ResponseObject(service.createModuleManagement(request));
    }

    @PutMapping
    public ResponseObject updateModule(@RequestBody SuModuleManagementRequest request) {
        return new ResponseObject(service.updateModuleManagement(request));
    }

    @DeleteMapping
    public ResponseObject deleteModule(@RequestParam(name = "id") UUID id) {
        return new ResponseObject(service.deleteModuleManagement(id));
    }

}
