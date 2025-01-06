package com.example.corebase.core.admin.developer.service;

import com.example.corebase.core.admin.developer.model.dto.AdResourceDetailResDto;
import com.example.corebase.core.admin.developer.model.dto.AdResourceMngResDto;
import com.example.corebase.core.admin.developer.model.request.AdResourceRequest;
import com.example.corebase.core.admin.developer.model.request.AdResourceFilterRequest;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.common.service.dto.CodeMngDTO;

import java.util.List;

public interface AdResourceMngService {

    PageableObject<AdResourceMngResDto> getPageResource(AdResourceFilterRequest req);

    AdResourceDetailResDto getResourceDetail(String id);

    Boolean createResource(AdResourceRequest req);

    Boolean updateResource(AdResourceRequest req);

    Boolean deleteResource(String id);

    List<CodeMngDTO> getFormList();
}
