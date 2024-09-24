package com.example.corebase.core.admin.developer.service.impl;

import com.example.corebase.core.admin.developer.model.dto.AdMenuDetailDto;
import com.example.corebase.core.admin.developer.model.dto.AdMenuFormListDto;
import com.example.corebase.core.admin.developer.model.dto.AdMenuMngResDto;
import com.example.corebase.core.admin.developer.model.request.AdMenuFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdMenuRequest;
import com.example.corebase.core.admin.developer.repository.AdMenuMngRepository;
import com.example.corebase.core.admin.developer.service.AdMenuMngService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.entity.cps.CpsMenuMngEntity;
import com.example.corebase.infrastructure.constant.Constants;
import com.example.corebase.infrastructure.constant.SequencesConstant;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.util.languageCommon.LanguageCommon;
import com.example.corebase.util.pageCommon.PageableCommon;
import com.example.corebase.util.sequenceCommon.SequencesUtil;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AdMenuMngServiceImpl implements AdMenuMngService {

    @Autowired
    private AdMenuMngRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SequencesUtil sequencesUtil;

    @Autowired
    private LanguageCommon languageCommon;

    @Override
    public PageableObject<AdMenuMngResDto> getPageMenu(AdMenuFilterRequest req) {
        Page<AdMenuMngResDto> dataResult = repository.getPageMenu(req, PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdMenuMngResDto.class));

        return new PageableObject<>(dataResult);
    }

    @Override
    public AdMenuDetailDto getMenuDetail(String id) {
        return null;
    }

    @Override
    @Transactional
    public Boolean createMenu(AdMenuRequest req) {
        return saveData(req);
    }

    @Override
    public Boolean updateMenu(AdMenuRequest req) {
        return saveData(req);
    }

    private Boolean saveData(AdMenuRequest req) {
        if (StringUtils.isEmpty(req.getId())) {
            req.setId(sequencesUtil
                    .generateSequence(SequencesConstant.CPS_MENU_MNG.getPrefix(),
                            SequencesConstant.CPS_MENU_MNG.getTableName()));
        }

        CpsMenuMngEntity entity = modelMapper.map(req, CpsMenuMngEntity.class);
        repository.save(entity);

        return true;
    }

    @Override
    @Transactional
    public Boolean deleteMenu(String id) {
        CpsMenuMngEntity cpsMenuMngEntity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        cpsMenuMngEntity.setDelYn(Constants.STATE_Y);

        repository.save(cpsMenuMngEntity);
        return true;
    }

    @Override
    public AdMenuFormListDto getFormList() {
        return null;
    }
}
