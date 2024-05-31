package com.example.corebase.core.superAdmin.systemManagement.service.impl;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectGroupFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectGroupRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuLoginResponseImpl;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuObjectElementGroupDetail;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuObjectGroupResponse;
import com.example.corebase.core.superAdmin.systemManagement.repository.SuObjectElementGroupRepository;
import com.example.corebase.core.superAdmin.systemManagement.repository.SuObjectManagementRepository;
import com.example.corebase.core.superAdmin.systemManagement.repository.SuObjectsGroupRepository;
import com.example.corebase.core.superAdmin.systemManagement.service.SuMenuManagementService;
import com.example.corebase.core.superAdmin.systemManagement.service.SuObjectsGroupService;
import com.example.corebase.entity.ObjectElementGroup;
import com.example.corebase.entity.ObjectGroups;
import com.example.corebase.entity.ObjectsEntity;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import com.example.corebase.infrastructure.constant.StatusExceptionConstants;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.util.LanguageCommon;
import com.example.corebase.util.PageableCommon;
import com.example.corebase.util.SimpleObjectResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SuObjectsGroupServiceImpl implements SuObjectsGroupService {

    @Autowired
    private SuObjectsGroupRepository repository;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private SuObjectManagementRepository objectManagementRepository;

    @Autowired
    private SuObjectElementGroupRepository elementGroupRepository;

    @Autowired
    @Qualifier("suMenuManagementServiceImpl")
    private SuMenuManagementService service;

    @Override
    public PageableObject<SuObjectGroupResponse> getPageObjectGroup(SuObjectGroupFilterRequest request) {
        return new PageableObject<>(repository.getAllObjectGroup(request, PageableCommon.getPageable(request)));
    }

    @Override
    @Transactional
    public Boolean createObjectGroup(SuObjectGroupRequest request) {
        try {
            if (repository.countByCodeAndIsActive(request.getCode(), ActiveStatus.ACTIVE) > 0) {
                throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.object_element.error.code"));
            }

            ObjectGroups objectGroups = new ObjectGroups();
            objectGroups.setCode(request.getCode());
            objectGroups.setName(request.getName());
            objectGroups.setSubName(request.getSubName());
            objectGroups.setUrlNote(request.getUrlNote());
            objectGroups.setOrderBy(request.getOrderBy());
            objectGroups.setStatus(request.getStatus());
            objectGroups.setRoleId(request.getRoleId());
            objectGroups.setModuleId(request.getModuleId());
            objectGroups.setId(repository.save(objectGroups).getId());

            List<ObjectElementGroup> objectElementGroups = request.getObject().stream().map(el -> {
                ObjectsEntity objectsEntity = objectManagementRepository.findById(el).orElse(null);
                if (objectsEntity != null) {
                    ObjectElementGroup objectElementGroup = new ObjectElementGroup();
                    objectElementGroup.setObjectGroupId(objectGroups.getId());
                    objectElementGroup.setObjectId(objectsEntity.getId());

                    return objectElementGroup;
                }
                return null;
            }).filter(el -> el != null).collect(Collectors.toList());

            elementGroupRepository.saveAll(objectElementGroups);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean updateObjectGroup(SuObjectGroupRequest request) {
        try {
            if (repository.countByCodeAndIdNotAndIsActive(request.getCode(), request.getId(), ActiveStatus.ACTIVE) > 0) {
                throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.object_element.error.code"));
            }

            ObjectGroups objectGroups = new ObjectGroups();
            objectGroups.setCode(request.getCode());
            objectGroups.setName(request.getName());
            objectGroups.setSubName(request.getSubName());
            objectGroups.setUrlNote(request.getUrlNote());
            objectGroups.setOrderBy(request.getOrderBy());
            objectGroups.setStatus(request.getStatus());
            objectGroups.setRoleId(request.getRoleId());
            objectGroups.setModuleId(request.getModuleId());
            objectGroups.setId(request.getId());

            Map<UUID, ObjectElementGroup> objectElementMap = getAllObjectElementByGroupId(request.getId());

            elementGroupRepository.saveAll(objectElementMap.values().stream().map(el -> {
                el.setIsActive(ActiveStatus.NOT_ACTIVE);
                return el;
            }).collect(Collectors.toList()));

            List<ObjectElementGroup> listElements = request.getObject().stream().map(el -> {
                ObjectsEntity objectsEntity = objectManagementRepository.findById(el).orElse(null);
                if (objectsEntity != null) {
                    ObjectElementGroup roleObjectEntity;
                    if (objectElementMap.containsKey(objectsEntity.getId())) {
                        roleObjectEntity = objectElementMap.get(objectsEntity.getId());
                    } else {
                        roleObjectEntity = new ObjectElementGroup();
                        roleObjectEntity.setObjectGroupId(objectGroups.getId());
                        roleObjectEntity.setObjectId(objectsEntity.getId());
                    }
                    roleObjectEntity.setIsActive(ActiveStatus.ACTIVE);
                    return roleObjectEntity;
                }
                return null;
            }).filter(el -> el != null).collect(Collectors.toList());

            elementGroupRepository.saveAll(listElements);
            repository.save(objectGroups);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return true;
    }

    public Map<UUID, ObjectElementGroup> getAllObjectElementByGroupId(UUID id) {
        Map<UUID, ObjectElementGroup> roleObjectEntityMap = new HashMap<>();
        elementGroupRepository.findByObjectGroupId(id).stream().forEach(el -> {
            roleObjectEntityMap.put(el.getObjectId(), el);
        });
        return roleObjectEntityMap;
    }

    @Override
    public SuObjectElementGroupDetail detailObjectGroup(UUID id) {
        Optional<ObjectGroups> objectGroups = repository.findById(id);

        if (objectGroups.isEmpty()) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.object_element.error.not_found"), StatusExceptionConstants.ERROR_UNKNOWN);
        }

        SuObjectElementGroupDetail req = new SuObjectElementGroupDetail();
        req.setId(objectGroups.get().getId());
        req.setCode(objectGroups.get().getCode());
        req.setName(objectGroups.get().getName());
        req.setModuleId(objectGroups.get().getModuleId());
        req.setOrderBy(objectGroups.get().getOrderBy());
        req.setObjectElementGroupDetails(repository.getObjectElementGroup(objectGroups.get().getId()));
        req.setStatus(objectGroups.get().getStatus());
        req.setRoleId(objectGroups.get().getRoleId());
        req.setSubName(objectGroups.get().getSubName());
        req.setUrlNote(objectGroups.get().getUrlNote());

        return req;
    }

    @Override
    @Transactional
    public Boolean deleteObjectGroup(UUID id) {
        Optional<ObjectGroups> objectGroups = repository.findById(id);

        if (objectGroups.isEmpty()) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.object_element.error.not_found"), StatusExceptionConstants.ERROR_UNKNOWN);
        }

        objectGroups.get().setIsActive(ActiveStatus.NOT_ACTIVE);
        repository.save(objectGroups.get());
        return true;
    }

    @Override
    public List<SimpleObjectResponse> getListRole() {
        return repository.getAllRolesActive();
    }

    @Override
    public List<SimpleObjectResponse> getListModule() {
        return repository.getAllModuleActive();
    }

    @Override
    public List<SuMenuLoginResponseImpl> getListObject() {
        return service.menuReturn(repository.getAllMenuLoginResponse());
    }
}
