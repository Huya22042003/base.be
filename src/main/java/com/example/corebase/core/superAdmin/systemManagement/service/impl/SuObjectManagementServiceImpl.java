package com.example.corebase.core.superAdmin.systemManagement.service.impl;

import com.example.corebase.core.base.model.PageableObject;
import com.example.corebase.core.superAdmin.systemManagement.model.request.SuObjectManagementFilterRequest;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuDetailResponse;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuMenuParentResponse;
import com.example.corebase.core.superAdmin.systemManagement.model.response.SuObjectsManagementResponse;
import com.example.corebase.core.superAdmin.systemManagement.repository.SuObjectManagementRepository;
import com.example.corebase.core.superAdmin.systemManagement.service.SuObjectManagementService;
import com.example.corebase.entity.ObjectsEntity;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import com.example.corebase.infrastructure.constant.StatusExceptionConstants;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.util.LanguageCommon;
import com.example.corebase.util.PageableCommon;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("objectManagementServiceImpl")
public class SuObjectManagementServiceImpl implements SuObjectManagementService {

    @Autowired
    @Qualifier("objectManagementRepository")
    private SuObjectManagementRepository repository;

    @Autowired
    private LanguageCommon languageCommon;

    @Override
    public PageableObject<SuObjectsManagementResponse> getAllObjects(SuObjectManagementFilterRequest request) {
        return new PageableObject<>(repository.getAllObjectsManagement(request, PageableCommon.getPageable(request)));
    }

    @Override
    public List<SuMenuParentResponse> getMenuParentModal(Long id) {
        return repository.getMenuParentList(id);
    }

    @Override
    @Transactional
    public ObjectsEntity createOrUpdateObjects(ObjectsEntity objectsEntity) {
        if (objectsEntity.getId() == null) {
            if (repository.countByCodeAndIsActive(objectsEntity.getCode(), ActiveStatus.ACTIVE) > 0) {
                throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.objects.error.code"));
            }
        } else {
            if (repository.countByCodeAndIdNotAndIsActive(objectsEntity.getCode(), objectsEntity.getId(), ActiveStatus.ACTIVE) > 0) {
                throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.objects.error.code"));
            }
        }
        return repository.save(objectsEntity);
    }

    @Override
    public SuMenuDetailResponse detailObjects(Long id) {
        SuMenuDetailResponse detailResponse = repository.findObjectsDetailById(id);
        if (detailResponse == null) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.objects.error.not_found"), StatusExceptionConstants.ERROR_UNKNOWN);
        }

        return detailResponse;
    }

    @Override
    @Transactional
    public ObjectsEntity deleteObjects(Long id) {
        Optional<ObjectsEntity> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.system.objects.error.not_found"), StatusExceptionConstants.ERROR_UNKNOWN);
        }
        optional.get().setIsActive(ActiveStatus.NOT_ACTIVE);
        return repository.save(optional.get());
    }
}
