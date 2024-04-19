package com.example.corebase.core.superAdmin.systemManagement.service.impl;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuRolesManagementDetailRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuRolesManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuRolesManagementRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuLoginResponseImpl;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuRolesManagementResponse;
import com.example.corebase.core.superAdmin.systemManagement.repository.SuObjectManagementRepository;
import com.example.corebase.core.superAdmin.systemManagement.repository.SuRoleObjectManagementRepository;
import com.example.corebase.core.superAdmin.systemManagement.repository.SuRolesManagementRepository;
import com.example.corebase.core.superAdmin.systemManagement.service.SuMenuManagementService;
import com.example.corebase.core.superAdmin.systemManagement.service.SuRoleManagementService;
import com.example.corebase.entity.ObjectsEntity;
import com.example.corebase.entity.RoleObjectEntity;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("roleManagementService")
public class SuRoleManagementServiceImpl implements SuRoleManagementService {

    @Autowired
    @Qualifier("rolesManagementRepository")
    private SuRolesManagementRepository repository;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    @Qualifier("suMenuManagementServiceImpl")
    private SuMenuManagementService service;

    @Autowired
    private SuRoleObjectManagementRepository roleObjectManagementRepository;

    @Autowired
    private SuObjectManagementRepository objectManagementRepository;

    @Override
    public PageableObject<SuRolesManagementResponse> getListRoles(SuRolesManagementFilterRequest request) {
        return new PageableObject<>(
                repository.findRoleOnPage(request, PageableCommon.getPageable(request)));
    }

    @Override
    public List<SuMenuLoginResponseImpl> getMenuLogin() {
        return service.menuReturn(repository.getAllMenuLoginResponse());
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

            List<RoleObjectEntity> listRoles = request.getObject().stream().map(el -> {
                ObjectsEntity objectsEntity = objectManagementRepository.findById(el).orElse(null);
                if (objectsEntity != null) {
                    RoleObjectEntity roleObjectEntity = new RoleObjectEntity();
                    roleObjectEntity.setRolesEntityId(entity);
                    roleObjectEntity.setObjectsEntityId(objectsEntity);
                    roleObjectEntity.setIsActive(ActiveStatus.ACTIVE);
                    return roleObjectEntity;
                }
                return null;
            }).filter(el -> el != null).collect(Collectors.toList());

            roleObjectManagementRepository.saveAll(listRoles);
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

        Map<Long, RoleObjectEntity> roleObjectMap = getAllRoleObjectByIdRole(request.getId());

        List<RoleObjectEntity> listRoles = request.getObject().stream().map(el -> {
            ObjectsEntity objectsEntity = objectManagementRepository.findById(el).orElse(null);
            if (objectsEntity != null) {
                RoleObjectEntity roleObjectEntity;
                if (roleObjectMap.containsKey(objectsEntity.getId())) {
                    roleObjectEntity = roleObjectMap.get(objectsEntity.getId());
                } else {
                    roleObjectEntity = new RoleObjectEntity();
                    roleObjectEntity.setRolesEntityId(entity);
                    roleObjectEntity.setObjectsEntityId(objectsEntity);
                }
                roleObjectEntity.setIsActive(ActiveStatus.ACTIVE);
                return roleObjectEntity;
            }
            return null;
        }).filter(el -> el != null).collect(Collectors.toList());

        roleObjectManagementRepository.saveAll(roleObjectMap.values().stream().map(el -> {
            el.setIsActive(ActiveStatus.NOT_ACTIVE);
            return el;
        }).collect(Collectors.toList()));

        roleObjectManagementRepository.saveAll(listRoles);

        return repository.save(entity);
    }

    public Map<Long, RoleObjectEntity> getAllRoleObjectByIdRole(Long id) {
        Map<Long, RoleObjectEntity> roleObjectEntityMap = new HashMap<>();
        roleObjectManagementRepository.getAllRoleObjectByRoleId(id).stream().forEach(el -> {
            roleObjectEntityMap.put(el.getObjectsEntityId().getId(), el);
        });
        return roleObjectEntityMap;
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
    public SuRolesManagementDetailRequest detailRoles(Long id) {
        Optional<RolesEntity> rolesEntity = repository.findById(id);

        if (rolesEntity.isEmpty()) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.roles.error.not_found"), StatusExceptionConstants.ERROR_UNKNOWN);
        }

        SuRolesManagementDetailRequest request = new SuRolesManagementDetailRequest();
        request.setRoleCode(rolesEntity.get().getRoleCode());
        request.setRoleName(rolesEntity.get().getRoleName());
        request.setRolesObjectDetailRequests(roleObjectManagementRepository.getRoleObjectDetail(id));

        return request;
    }
}
