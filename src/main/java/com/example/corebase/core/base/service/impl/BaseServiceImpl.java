package com.example.corebase.core.base.service.impl;

import com.example.corebase.core.base.model.AuthLoginService;
import com.example.corebase.core.base.model.ObjectDto;
import com.example.corebase.core.base.service.BaseService;
import com.example.corebase.util.languageCommon.LanguageCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseServiceImpl implements BaseService {

//    @Autowired
//    private ObjectsRepository objectsRepository;

    @Autowired
    private AuthLoginService authLoginService;

    @Autowired
    private LanguageCommon languageCommon;

    @Override
    public List<ObjectDto> getListObjectByUser() {
//        List<ObjectsEntity> list = objectsRepository.getObjectsByIdUsers(authLoginService.getAuth().getId());
//        List<ObjectsEntity> list = objectsRepository.getObjectsByIdUsers(1L);
//        List<ObjectDto> response = list.stream().map(el ->
//                new ObjectDto(languageCommon.getMessageProperties(el.getKey()), el.getIcons(), el.getUrl()))
//        .collect(Collectors.toList());
        return null;
    }
}
