package com.example.corebase.core.superAdmin.systemManagement.service.impl;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuRolesManagementDetailRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuRolesManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuRolesManagementRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuLoginResponseImpl;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuRolesManagementResponse;
import com.example.corebase.core.superAdmin.systemManagement.repository.SuRolesManagementRepository;
import com.example.corebase.core.superAdmin.systemManagement.service.SuMenuManagementService;
import com.example.corebase.core.superAdmin.systemManagement.service.SuRoleManagementService;
import com.example.corebase.entity.RolesEntity;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import com.example.corebase.infrastructure.constant.StatusExceptionConstants;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.util.LanguageCommon;
import com.example.corebase.util.PageableCommon;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("roleManagementService")
public class SuRoleManagementServiceImpl implements SuRoleManagementService {

    @Autowired
    @Qualifier("rolesManagementRepository")
    private SuRolesManagementRepository repository;

    @Autowired
    private LanguageCommon languageCommon;

    @Override
    public PageableObject<SuRolesManagementResponse> getListRoles(SuRolesManagementFilterRequest request) {
        return new PageableObject<>(
                repository.findRoleOnPage(request, PageableCommon.getPageable(request)));
    }

    @Override
    @Transactional
    public RolesEntity addRoles(SuRolesManagementRequest request) {
        try {
            if (repository.countByRoleCodeAndIsActive(request.getRoleCode(), ActiveStatus.ACTIVE) > 0) {
                throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.roles.error.code"));
            }

            RolesEntity entity = new RolesEntity();
            entity.setIsActive(ActiveStatus.ACTIVE);
            entity.setRoleCode(request.getRoleCode());
            entity.setRoleName(request.getRoleName());
            entity.setId(repository.save(entity).getId());

            return repository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.error"));
        }
    }

    @Override
    @Transactional
    public RolesEntity updateRoles(SuRolesManagementRequest request) {
        if (repository.countByRoleCodeAndIdNotAndIsActive(request.getRoleCode(), request.getId(), ActiveStatus.ACTIVE) > 0) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.roles.error.code"));
        }

        RolesEntity entity = new RolesEntity();
        entity.setId(request.getId());
        entity.setIsActive(ActiveStatus.ACTIVE);
        entity.setRoleCode(request.getRoleCode());
        entity.setRoleName(request.getRoleName());

        return repository.save(entity);
    }

    @Override
    public RolesEntity deleteRoles(UUID id) {
        Optional<RolesEntity> rolesEntity = repository.findById(id);

        if (rolesEntity.isEmpty()) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.roles.error.not_found"), StatusExceptionConstants.ERROR_UNKNOWN);
        }

        rolesEntity.get().setIsActive(ActiveStatus.NOT_ACTIVE);
        return repository.save(rolesEntity.get());
    }

    @Override
    public SuRolesManagementDetailRequest detailRoles(UUID id) {
        Optional<RolesEntity> rolesEntity = repository.findById(id);

        if (rolesEntity.isEmpty()) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.roles.error.not_found"), StatusExceptionConstants.ERROR_UNKNOWN);
        }

        SuRolesManagementDetailRequest request = new SuRolesManagementDetailRequest();
        request.setId(rolesEntity.get().getId());
        request.setRoleCode(rolesEntity.get().getRoleCode());
        request.setRoleName(rolesEntity.get().getRoleName());

        return request;
    }
}
