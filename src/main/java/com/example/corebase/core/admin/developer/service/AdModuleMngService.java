package com.example.corebase.core.admin.developer.service;

import com.example.corebase.core.admin.developer.model.dto.AdModuleDetailDto;
import com.example.corebase.core.admin.developer.model.dto.AdModuleResDto;
import com.example.corebase.core.admin.developer.model.request.AdModuleFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdModuleRequest;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.common.service.dto.CodeMngDTO;

import java.util.List;

public interface AdModuleMngService {

    PageableObject<AdModuleResDto> getPageModule(AdModuleFilterRequest req);
    Boolean createModule(AdModuleRequest req);
    Boolean updateModule(AdModuleRequest req);
    Boolean deleteModule(String id);
    AdModuleDetailDto getModuleDetail(String id);
    List<CodeMngDTO> listModuleForm();
}
