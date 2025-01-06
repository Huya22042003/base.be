package com.example.corebase.core.admin.developer.service.impl;

import com.example.corebase.core.admin.developer.model.dto.AdPermissionResDto;
import com.example.corebase.core.admin.developer.model.request.AdPermissionDetailRequest;
import com.example.corebase.core.admin.developer.model.request.AdPermissionFilterRequest;
import com.example.corebase.core.admin.developer.model.request.AdPermissionRequest;
import com.example.corebase.core.admin.developer.repository.AdApiMenuPermissionsRepository;
import com.example.corebase.core.admin.developer.repository.AdPermissionRepository;
import com.example.corebase.core.admin.developer.service.AdPermissionService;
import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.entity.cps.CpsApiMenuPermissionsEntity;
import com.example.corebase.entity.cps.CpsPermissionEntity;
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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdPermissionServiceImpl implements AdPermissionService {

    @Autowired
    private AdPermissionRepository repository;

    @Autowired
    private AdApiMenuPermissionsRepository apiMenuRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SequencesUtil sequencesUtil;

    @Autowired
    private LanguageCommon languageCommon;

    @Override
    public PageableObject<AdPermissionResDto> getPagePermission(AdPermissionFilterRequest req) {
        Page<AdPermissionResDto> dataResult = repository.getPagePermission(req, PageableCommon.getPageable(req))
                .map(item -> modelMapper.map(item, AdPermissionResDto.class));

        return new PageableObject<>(dataResult);
    }

    @Override
    @Transactional
    public Boolean updatePermission(AdPermissionRequest req) {
        CpsPermissionEntity entity = modelMapper.map(req, CpsPermissionEntity.class);

        if (StringUtils.isEmpty(entity.getId())) {
            entity.setId(sequencesUtil
                    .generateSequence(SequencesConstant.CPS_PERMISSION.getPrefix(),
                            SequencesConstant.CPS_PERMISSION.getTableName()));
        }

        List<String> listId = new ArrayList<>();
        List<CpsApiMenuPermissionsEntity> apiMenuPermissionsEntities = req.getDetail().stream().map(item -> {
            CpsApiMenuPermissionsEntity dataReturn = modelMapper.map(item, CpsApiMenuPermissionsEntity.class);

            if (StringUtils.isEmpty(dataReturn.getId())) {
                dataReturn.setId(sequencesUtil
                        .generateSequence(SequencesConstant.CPS_API_MENU_PERMISSION.getPrefix(),
                                SequencesConstant.CPS_API_MENU_PERMISSION.getTableName()));
            } else {
                listId.add(dataReturn.getId());
            }

            return dataReturn;
        }).toList();

        if (!listId.isEmpty()) {
            List<CpsApiMenuPermissionsEntity> listRemove = apiMenuRepository.findByIdNotInAndDelYn(listId, Constants.STATE_N);
            apiMenuPermissionsEntities.addAll(listRemove);
        }

        repository.save(entity);
        apiMenuRepository.saveAll(apiMenuPermissionsEntities);

        return true;
    }

    @Override
    @Transactional
    public Boolean deletePermission(String id) {
        CpsPermissionEntity entity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        entity.setDelYn(Constants.STATE_Y);

        List<CpsApiMenuPermissionsEntity> listApiMenu = apiMenuRepository.findByPermissionIdAndDelYn(id, Constants.STATE_N);

        listApiMenu.stream().map(item -> {
            item.setDelYn(Constants.STATE_Y);
            return item;
        }).collect(Collectors.toList());

        repository.save(entity);
        apiMenuRepository.saveAll(listApiMenu);
        return true;
    }

    @Override
    public AdPermissionRequest getPermissionDetail(String id) {
        CpsPermissionEntity entity = repository.findById(id)
                .orElseThrow(() -> new BadRequestCustomException(languageCommon.getMessageProperties("message.notfound")));

        List<CpsApiMenuPermissionsEntity> listApiMenu = apiMenuRepository.findByPermissionIdAndDelYn(id, Constants.STATE_N);

        AdPermissionRequest permissionRequest = modelMapper.map(entity, AdPermissionRequest.class);

        List<AdPermissionDetailRequest> detail = listApiMenu.stream()
                .map(item -> modelMapper.map(item, AdPermissionDetailRequest.class)).toList();

        permissionRequest.setDetail(detail);

        return permissionRequest;
    }
}
