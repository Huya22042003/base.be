package com.example.corebase.core.superAdmin.systemManagement.service;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectGroupFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectGroupRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuLoginResponseImpl;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuObjectElementGroupDetail;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuObjectGroupResponse;
import com.example.corebase.util.SimpleObjectResponse;

import java.util.List;
import java.util.UUID;

public interface SuObjectsGroupService {
    PageableObject<SuObjectGroupResponse> getPageObjectGroup(SuObjectGroupFilterRequest request);
    Boolean createObjectGroup(SuObjectGroupRequest request);
    Boolean updateObjectGroup(SuObjectGroupRequest request);
    SuObjectElementGroupDetail detailObjectGroup(UUID id);
    Boolean deleteObjectGroup(UUID id);
    List<SimpleObjectResponse> getListRole();
    List<SimpleObjectResponse> getListModule();
    List<SuMenuLoginResponseImpl> getListObject();
}
