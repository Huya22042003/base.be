package com.example.corebase.core.superAdmin.systemManagement.service;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.ObjectManagementFilterRequest;
import com.example.corebase.entity.Objects;
import com.example.corebase.infrastructure.constant.TypeObjects;

public interface ObjectManagementService {
    PageableObject<Objects> getAllObjects(ObjectManagementFilterRequest objectManagementFilterRequest);
}
