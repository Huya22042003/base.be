package com.example.corebase.core.superAdmin.systemManagement.service.impl;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.ObjectManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.repository.ObjectManagementRepository;
import com.example.corebase.core.superAdmin.systemManagement.service.ObjectManagementService;
import com.example.corebase.entity.ObjectsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("objectManagementServiceImpl")
public class ObjectManagementServiceImpl implements ObjectManagementService {

    @Autowired
    @Qualifier("objectManagementRepository")
    private ObjectManagementRepository repository;

    @Override
    public PageableObject<ObjectsEntity> getAllObjects(ObjectManagementFilterRequest request) {
        return new PageableObject<>(repository.findByCodeContainsAndNameContains(request.getCode(),
                request.getName(), request.getPageable()));
    }

    @Override
    public ObjectsEntity createOrUpdateObjects(ObjectsEntity objectsEntity) {
        return repository.save(objectsEntity);
    }
}
