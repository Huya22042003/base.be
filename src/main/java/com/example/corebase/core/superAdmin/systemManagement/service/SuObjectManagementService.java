package com.example.corebase.core.superAdmin.systemManagement.service;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuObjectsManagementResponse;
import com.example.corebase.entity.ObjectsEntity;

public interface SuObjectManagementService {
    PageableObject<SuObjectsManagementResponse> getAllObjects(SuObjectManagementFilterRequest suObjectManagementFilterRequest);
    ObjectsEntity createOrUpdateObjects(ObjectsEntity objectsEntity);
}
