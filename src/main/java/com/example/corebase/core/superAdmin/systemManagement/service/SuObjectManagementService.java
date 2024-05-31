package com.example.corebase.core.superAdmin.systemManagement.service;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuDetailResponse;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuParentResponse;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuObjectsManagementResponse;
import com.example.corebase.entity.ObjectsEntity;

import java.util.List;
import java.util.UUID;

public interface SuObjectManagementService {
    PageableObject<SuObjectsManagementResponse> getAllObjects(SuObjectManagementFilterRequest suObjectManagementFilterRequest);
    List<SuMenuParentResponse> getMenuParentModal(String id);
    List<SuMenuParentResponse> getMenuParentModal();
    ObjectsEntity createOrUpdateObjects(ObjectsEntity objectsEntity);
    SuMenuDetailResponse detailObjects(UUID id);
    ObjectsEntity deleteObjects(UUID id);
}
