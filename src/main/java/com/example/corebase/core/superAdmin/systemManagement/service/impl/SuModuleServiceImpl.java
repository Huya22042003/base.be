package com.example.corebase.core.superAdmin.systemManagement.service.impl;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuModuleFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuModuleManagementRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuModuleResponse;
import com.example.corebase.core.superAdmin.systemManagement.repository.SuModuleRepository;
import com.example.corebase.core.superAdmin.systemManagement.service.SuModuleService;
import com.example.corebase.entity.ModuleEntity;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.util.LanguageCommon;
import com.example.corebase.util.PageableCommon;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SuModuleServiceImpl implements SuModuleService {

    @Autowired
    private SuModuleRepository repository;

    @Autowired
    private LanguageCommon languageCommon;

    @Override
    public PageableObject<SuModuleResponse> getPageModuleResponse(SuModuleFilterRequest request) {
        return new PageableObject<>(repository.getAllModuleManagement(request, PageableCommon.getPageable(request)));
    }

    @Override
    @Transactional
    public Boolean createModuleManagement(SuModuleManagementRequest request) {
        try {
            if (repository.countByCodeAndIsActive(request.getCode(), ActiveStatus.ACTIVE) > 0) {
                throw new BadRequestCustomException(languageCommon.
                        getMessageProperties("message.system.module.error.code"));
            }

            ModuleEntity moduleEntity = new ModuleEntity();
            moduleEntity.setCode(request.getCode());
            moduleEntity.setName(request.getName());
            moduleEntity.setNote(request.getNote());
            moduleEntity.setStatus(request.getStatus());
            moduleEntity.setUrl(request.getUrl());
            repository.save(moduleEntity);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public Boolean updateModuleManagement(SuModuleManagementRequest request) {
        try {
            if (repository.countByCodeAndIdNotAndIsActive(request.getCode(), request.getId(), ActiveStatus.ACTIVE) > 0) {
                throw new BadRequestCustomException(languageCommon.
                        getMessageProperties("message.system.module.error.code"));
            }

            ModuleEntity moduleEntity = new ModuleEntity();
            moduleEntity.setId(request.getId());
            moduleEntity.setCode(request.getCode());
            moduleEntity.setName(request.getName());
            moduleEntity.setNote(request.getNote());
            moduleEntity.setStatus(request.getStatus());
            moduleEntity.setUrl(request.getUrl());
            repository.save(moduleEntity);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public Boolean deleteModuleManagement(UUID id) {
        try {
            ModuleEntity moduleEntity = repository.findById(id).orElseThrow(() ->
                    new BadRequestCustomException(languageCommon.getMessageProperties("message.system.module.error.code"))
            );

            moduleEntity.setIsActive(ActiveStatus.NOT_ACTIVE);
            repository.save(moduleEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ModuleEntity detailModuleEntity(UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new BadRequestCustomException(languageCommon.getMessageProperties("message.system.module.error.code"))
        );
    }
}
