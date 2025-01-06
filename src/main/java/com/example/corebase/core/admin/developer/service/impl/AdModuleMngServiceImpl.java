package com.example.corebase.core.admin.developer.service.impl;

import com.example.corebase.core.admin.developer.model.dto.AdModuleDetailDto;
import com.example.corebase.core.admin.developer.model.dto.AdModuleResDto;
import com.example.corebase.core.admin.developer.model.request.AdModuleFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdModuleRequest;
import com.example.corebase.core.admin.developer.repository.AdModuleMngRepository;
import com.example.corebase.core.admin.developer.service.AdModuleMngService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.common.service.dto.CodeMngDTO;
import com.example.corebase.entity.cps.CpsModuleMngEntity;
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
import java.util.stream.Collectors;

@Service
public class AdModuleMngServiceImpl implements AdModuleMngService {

    @Autowired
    private AdModuleMngRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SequencesUtil sequencesUtil;

    @Autowired
    private LanguageCommon languageCommon;

    @Override
    public PageableObject<AdModuleResDto> getPageModule(AdModuleFilterRequest req) {
        Page<AdModuleResDto> dataResult = repository.getPageModule(req, PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdModuleResDto.class));

        return new PageableObject<>(dataResult);
    }

    @Override
    public Boolean createModule(AdModuleRequest req) {
        return saveData(req);
    }

    @Override
    public Boolean updateModule(AdModuleRequest req) {
        return saveData(req);
    }

    @Override
    public Boolean deleteModule(String id) {
        CpsModuleMngEntity entity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        entity.setDelYn(Constants.STATE_Y);

        repository.save(entity);
        return true;
    }

    @Override
    public AdModuleDetailDto getModuleDetail(String id) {
        CpsModuleMngEntity entity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        return modelMapper.map(entity, AdModuleDetailDto.class);
    }

    @Override
    public List<CodeMngDTO> listModuleForm() {
        List<CpsModuleMngEntity> cpsModuleMngEntities = repository.findByDelYnOrderByCreatedDate(Constants.STATE_N);

        List<CodeMngDTO> listModule = cpsModuleMngEntities.stream().map(item -> {
            CodeMngDTO result = new CodeMngDTO();

            result.setLabel(item.getName());
            result.setValue(item.getId());

            return result;
        }).collect(Collectors.toList());

        return listModule;
    }

    private Boolean saveData(AdModuleRequest req) {
        if (StringUtils.isEmpty(req.getId())) {
            req.setId(sequencesUtil
                    .generateSequence(SequencesConstant.CPS_MODULE_MNG.getPrefix(),
                            SequencesConstant.CPS_MODULE_MNG.getTableName()));
        }

        CpsModuleMngEntity entity = modelMapper.map(req, CpsModuleMngEntity.class);
        entity.setDelYn(Constants.STATE_N);
        repository.save(entity);
        return true;
    }
}
