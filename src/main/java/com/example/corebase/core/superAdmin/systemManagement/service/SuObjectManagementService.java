package com.example.corebase.core.superAdmin.systemManagement.service;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuDetailResponse;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuParentResponse;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuObjectsManagementResponse;
import com.example.corebase.entity.ObjectsEntity;

import java.util.List;

public interface SuObjectManagementService {
    PageableObject<SuObjectsManagementResponse> getAllObjects(SuObjectManagementFilterRequest suObjectManagementFilterRequest);
    List<SuMenuParentResponse> getMenuParentModal(Long id);
    ObjectsEntity createOrUpdateObjects(ObjectsEntity objectsEntity);
    SuMenuDetailResponse detailObjects(Long id);
    ObjectsEntity deleteObjects(Long id);
}
