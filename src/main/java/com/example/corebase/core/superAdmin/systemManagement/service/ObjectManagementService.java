package com.example.corebase.core.superAdmin.systemManagement.service;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.ObjectManagementFilterRequest;
import com.example.corebase.entity.ObjectsEntity;

public interface ObjectManagementService {
    PageableObject<ObjectsEntity> getAllObjects(ObjectManagementFilterRequest objectManagementFilterRequest);
    ObjectsEntity createOrUpdateObjects(ObjectsEntity objectsEntity);
}
