package com.example.corebase.core.superAdmin.systemManagement.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.RolesManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.service.RoleManagementService;
import com.example.corebase.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/super-admin/roles")
public class RolesManagementController {

    @Autowired
    @Qualifier("roleManagementService")
    private RoleManagementService service;

    @GetMapping
    public ResponseObject getPageRoles(RolesManagementFilterRequest request) {
        return new ResponseObject(service.getListRoles(request));
    }

    @PostMapping
    public ResponseObject createRoles(Roles roles) {
        return new ResponseObject(service.addRoles(roles));
    }

    @PutMapping
    public ResponseObject updateRoles(Roles roles) {
        return new ResponseObject(service.updateRoles(roles));
    }

    @DeleteMapping("/{id}")
    public ResponseObject deleteRoles(@PathVariable(name = "id") Long id) {
        return new ResponseObject(service.deleteRoles(id));
    }
}
