package com.example.corebase.core.superAdmin.informationManagement.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.core.superAdmin.informationManagement.model.request.SuObjectGroupFilterRequest;
import com.example.corebase.core.superAdmin.informationManagement.model.request.SuPremiumTypeCreateRequest;
import com.example.corebase.core.superAdmin.informationManagement.model.request.SuPremiumTypeFilterRequest;
import com.example.corebase.core.superAdmin.informationManagement.service.SuPremiumManagementService;
import com.example.corebase.entity.PremiumTypesEntity;
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

import java.util.UUID;

@RequestMapping("/super-admin/premium-management")
@RestController
public class SuPremiumManagementController {

    @Autowired
    @Qualifier("premiumManagementService")
    private SuPremiumManagementService service;

    @PostMapping("/list")
    public ResponseObject getAllPremium(@RequestBody SuPremiumTypeFilterRequest request) {
        return new ResponseObject(service.getAllPremiumType(request));
    }

    @PostMapping
    public ResponseObject createPremium(@RequestBody SuPremiumTypeCreateRequest types) {
        return new ResponseObject(service.createPremiumType(types));
    }

    @PutMapping
    public ResponseObject updatePremium(@RequestBody SuPremiumTypeCreateRequest types) {
        return new ResponseObject(service.updatePremiumType(types));
    }

    @DeleteMapping("/{id}")
    public ResponseObject deletePremium(@PathVariable String id) {
        return new ResponseObject(service.deletePremiumType(UUID.fromString(id)));
    }

    @GetMapping("/all-role")
    public ResponseObject getAllRoleCode() {
        return new ResponseObject(service.getListRoles());
    }

    @PostMapping("/all-object-group")
    public ResponseObject getAllObjectGroup(@RequestBody SuObjectGroupFilterRequest request) {
        return new ResponseObject(service.getAllObjectGroup(request));
    }

}
