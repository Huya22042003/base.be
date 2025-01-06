package com.example.corebase.core.admin.developer.service;

import com.example.corebase.core.admin.developer.model.dto.AdPermissionResDto;
import com.example.corebase.core.admin.developer.model.request.AdPermissionFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdPermissionRequest;
import com.example.corebase.core.base.model.PageableObject;

public interface AdPermissionService {

    PageableObject<AdPermissionResDto> getPagePermission(AdPermissionFilterRequest req);
    Boolean updatePermission(AdPermissionRequest req);
    Boolean deletePermission(String id);
    AdPermissionRequest getPermissionDetail(String id);
}
