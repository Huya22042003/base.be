package com.example.corebase.core.superAdmin.systemManagement.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuRolesManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.service.SuRoleManagementService;
import com.example.corebase.entity.RolesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/super-admin/roles")
public class SuRolesManagementController {

    @Autowired
    @Qualifier("roleManagementService")
    private SuRoleManagementService service;

    @PostMapping("/list")
    public ResponseObject getPageRoles(@RequestBody SuRolesManagementFilterRequest request) {
        return new ResponseObject(service.getListRoles(request));
    }

    @PostMapping
    public ResponseObject createRoles(RolesEntity rolesEntity) {
        return new ResponseObject(service.addRoles(rolesEntity));
    }

    @PutMapping
    public ResponseObject updateRoles(RolesEntity rolesEntity) {
        return new ResponseObject(service.updateRoles(rolesEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseObject deleteRoles(@PathVariable(name = "id") Long id) {
        return new ResponseObject(service.deleteRoles(id));
    }

    @GetMapping("/{id}")
    public ResponseObject detailRoles(@PathVariable(name = "id") Long id) {
        return new ResponseObject(service.detailRoles(id));
    }
}
