package com.example.corebase.core.superAdmin.premiumManagement.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.core.superAdmin.premiumManagement.model.request.PremiumTypeFilterRequest;
import com.example.corebase.core.superAdmin.premiumManagement.service.PremiumManagementService;
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

@RequestMapping("/api/super-admin/premium-management")
@RestController
public class PremiumManagementController {

    @Autowired
    @Qualifier("premiumManagementService")
    private PremiumManagementService service;

    @GetMapping
    public ResponseObject getAllPremium(PremiumTypeFilterRequest request) {
        return new ResponseObject(service.getAllPremiumType(request));
    }

    @PostMapping
    public ResponseObject createPremium(@RequestBody PremiumTypesEntity types) {
        return new ResponseObject(service.createPremiumType(types));
    }

    @PutMapping
    public ResponseObject updatePremium(@RequestBody PremiumTypesEntity types) {
        return new ResponseObject(service.updatePremiumType(types));
    }

    @DeleteMapping("/{id}")
    public ResponseObject deletePremium(@PathVariable Long id) {
        return new ResponseObject(service.deletePremiumType(id));
    }

}
