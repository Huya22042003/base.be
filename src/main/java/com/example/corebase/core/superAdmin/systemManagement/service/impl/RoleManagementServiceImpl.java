package com.example.corebase.core.superAdmin.systemManagement.service.impl;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.RolesManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.repository.RolesManagementRepository;
import com.example.corebase.core.superAdmin.systemManagement.service.RoleManagementService;
import com.example.corebase.entity.RolesEntity;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("roleManagementService")
public class RoleManagementServiceImpl implements RoleManagementService {

    @Autowired
    @Qualifier("rolesManagementRepository")
    private RolesManagementRepository repository;

    @Override
    public PageableObject<RolesEntity> getListRoles(RolesManagementFilterRequest request) {
        return new PageableObject<>(
                repository.findByRoleNameContainingAndRoleCodeContaining(request.getName(),
                        request.getCode(), request.getPageable()));
    }

    @Override
    public RolesEntity addRoles(RolesEntity rolesEntity) {
        return repository.save(rolesEntity);
    }

    @Override
    public RolesEntity updateRoles(RolesEntity rolesEntity) {
        return repository.save(rolesEntity);
    }

    @Override
    public RolesEntity deleteRoles(Long id) {
        RolesEntity rolesEntity = repository.findById(id).get();
        rolesEntity.setIsActive(ActiveStatus.NOT_ACTIVE);
        return repository.save(rolesEntity);
    }
}
