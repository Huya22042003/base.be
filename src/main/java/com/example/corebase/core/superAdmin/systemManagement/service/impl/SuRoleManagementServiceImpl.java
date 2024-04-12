package com.example.corebase.core.superAdmin.systemManagement.service.impl;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuRolesManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.repository.SuRolesManagementRepository;
import com.example.corebase.core.superAdmin.systemManagement.service.SuRoleManagementService;
import com.example.corebase.entity.RolesEntity;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import com.example.corebase.infrastructure.constant.StatusExceptionConstants;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.util.LanguageCommon;
import com.example.corebase.util.PageableCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("roleManagementService")
public class SuRoleManagementServiceImpl implements SuRoleManagementService {

    @Autowired
    @Qualifier("rolesManagementRepository")
    private SuRolesManagementRepository repository;

    @Autowired
    private LanguageCommon languageCommon;

    @Override
    public PageableObject<RolesEntity> getListRoles(SuRolesManagementFilterRequest request) {
        return new PageableObject<>(
                repository.findByRoleNameContainingAndRoleCodeContainingAndIsActive(request.getName(),
                        request.getCode(), ActiveStatus.ACTIVE, PageableCommon.getPageable(request)));
    }

    @Override
    public RolesEntity addRoles(RolesEntity rolesEntity) {
        if (repository.countByRoleCodeAndIsActive(rolesEntity.getRoleCode(), ActiveStatus.ACTIVE) > 0) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.roles.error.code"));
        }
        return repository.save(rolesEntity);
    }

    @Override
    public RolesEntity updateRoles(RolesEntity rolesEntity) {
        if (repository.countByRoleCodeAndIdNotAndIsActive(rolesEntity.getRoleCode(), rolesEntity.getId(), ActiveStatus.ACTIVE) > 0) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.roles.error.code"));
        }
        return repository.save(rolesEntity);
    }

    @Override
    public RolesEntity deleteRoles(Long id) {
        Optional<RolesEntity> rolesEntity = repository.findById(id);
        if (rolesEntity.isEmpty()) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.roles.error.not_found"), StatusExceptionConstants.ERROR_UNKNOWN);
        }
        rolesEntity.get().setIsActive(ActiveStatus.NOT_ACTIVE);
        return repository.save(rolesEntity.get());
    }

    @Override
    public RolesEntity detailRoles(Long id) {
        Optional<RolesEntity> rolesEntity = repository.findById(id);
        if (rolesEntity.isEmpty()) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.roles.error.not_found"), StatusExceptionConstants.ERROR_UNKNOWN);
        }
        return rolesEntity.get();
    }
}
