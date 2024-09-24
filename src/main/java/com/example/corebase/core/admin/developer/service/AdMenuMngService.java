package com.example.corebase.core.admin.developer.service;

import com.example.corebase.core.admin.developer.model.dto.AdMenuDetailDto;
import com.example.corebase.core.admin.developer.model.dto.AdMenuFormListDto;
import com.example.corebase.core.admin.developer.model.dto.AdMenuMngResDto;
import com.example.corebase.core.admin.developer.model.request.AdMenuFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdMenuRequest;
import com.example.corebase.core.base.model.PageableObject;

public interface AdMenuMngService {

    PageableObject<AdMenuMngResDto> getPageMenu(AdMenuFilterRequest req);

    AdMenuDetailDto getMenuDetail(String id);

    Boolean createMenu(AdMenuRequest req);

    Boolean updateMenu(AdMenuRequest req);

    Boolean deleteMenu(String id);

    AdMenuFormListDto getFormList();
}
