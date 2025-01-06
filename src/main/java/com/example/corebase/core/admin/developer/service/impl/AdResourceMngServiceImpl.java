package com.example.corebase.core.admin.developer.service.impl;

import com.example.corebase.core.admin.developer.model.dto.AdResourceDetailResDto;
import com.example.corebase.core.admin.developer.model.dto.AdResourceMngResDto;
import com.example.corebase.core.admin.developer.model.request.AdResourceRequest;
import com.example.corebase.core.admin.developer.model.request.AdResourceFilterRequest;
import com.example.corebase.core.admin.developer.repository.AdResourceMngRepository;
import com.example.corebase.core.admin.developer.service.AdModuleMngService;
import com.example.corebase.core.admin.developer.service.AdResourceMngService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.common.service.dto.CodeMngDTO;
import com.example.corebase.entity.cps.CpsResourceMngEntity;
import com.example.corebase.infrastructure.constant.Constants;
import com.example.corebase.infrastructure.constant.SequencesConstant;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.util.languageCommon.LanguageCommon;
import com.example.corebase.util.pageCommon.PageableCommon;
import com.example.corebase.util.sequenceCommon.SequencesUtil;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdResourceMngServiceImpl implements AdResourceMngService {

    @Autowired
    private AdResourceMngRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SequencesUtil sequencesUtil;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    private AdModuleMngService moduleMngService;

    @Override
    public PageableObject<AdResourceMngResDto> getPageResource(AdResourceFilterRequest req) {
        Page<AdResourceMngResDto> dataResult = repository.getPageResource(req, PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdResourceMngResDto.class));
        return new PageableObject<>(dataResult);
    }

    @Override
    public AdResourceDetailResDto getResourceDetail(String id) {
        CpsResourceMngEntity entity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        return modelMapper.map(entity, AdResourceDetailResDto.class);
    }

    @Override
    public Boolean createResource(AdResourceRequest req) {
        return saveData(req);
    }

    @Override
    public Boolean updateResource(AdResourceRequest req) {
        return saveData(req);
    }

    @Override
    public Boolean deleteResource(String id) {
        CpsResourceMngEntity entity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        entity.setDelYn(Constants.STATE_Y);

        repository.save(entity);
        return true;
    }

    @Override
    public List<CodeMngDTO> getFormList() {
        List<CodeMngDTO> listModule = moduleMngService.listModuleForm();

        return listModule;
    }

    private Boolean saveData(AdResourceRequest req) {
        if (StringUtils.isEmpty(req.getId())) {
            req.setId(sequencesUtil
                    .generateSequence(SequencesConstant.CPS_MODULE_MNG.getPrefix(),
                            SequencesConstant.CPS_MODULE_MNG.getTableName()));
        }

        CpsResourceMngEntity entity = modelMapper.map(req, CpsResourceMngEntity.class);
        entity.setDelYn(Constants.STATE_N);
        repository.save(entity);
        return true;
    }
}
