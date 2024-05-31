package com.example.corebase.core.superAdmin.systemManagement.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectGroupFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectGroupRequest;
import com.example.corebase.core.superAdmin.systemManagement.service.SuObjectsGroupService;
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
@RequestMapping("/super-admin/object-group")
public class SuObjectGroupController {

    @Autowired
    private SuObjectsGroupService service;

    @PostMapping("/list")
    public ResponseObject getPageObjectGroup(@RequestBody SuObjectGroupFilterRequest request) {
        return new ResponseObject(service.getPageObjectGroup(request));
    }

    @PostMapping
    public ResponseObject createObjectGroup(@RequestBody SuObjectGroupRequest request) {
        return new ResponseObject(service.createObjectGroup(request));
    }

    @PutMapping
    public ResponseObject updateObjectGroup(@RequestBody SuObjectGroupRequest request) {
        return new ResponseObject(service.updateObjectGroup(request));
    }

    @DeleteMapping
    public ResponseObject deleteObjectGroup(@RequestParam(name = "id") UUID id) {
        return new ResponseObject(service.deleteObjectGroup(id));
    }

    @GetMapping
    public ResponseObject getDetailObjectGroup(@RequestParam(name = "id") UUID id) {
        return new ResponseObject(service.detailObjectGroup(id));
    }

    @GetMapping("/role-all")
    public ResponseObject getRoleAll() {
        return new ResponseObject(service.getListRole());
    }

    @GetMapping("/object-all")
    public ResponseObject getObjectAll() {
        return new ResponseObject(service.getListObject());
    }

    @GetMapping("/module-all")
    public ResponseObject getModuleAll() {
        return new ResponseObject(service.getListModule());
    }
}
