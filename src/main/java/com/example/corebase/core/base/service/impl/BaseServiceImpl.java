package com.example.corebase.core.base.service.impl;

import com.example.corebase.core.base.model.AuthLoginService;
import com.example.corebase.core.base.model.ObjectDto;
import com.example.corebase.core.base.service.BaseService;
import com.example.corebase.entity.Objects;
import com.example.corebase.repository.ObjectsRepository;
import com.example.corebase.util.LanguageCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private ObjectsRepository objectsRepository;

    @Autowired
    private AuthLoginService authLoginService;

    @Autowired
    private LanguageCommon languageCommon;

    @Override
    public List<ObjectDto> getListObjectByUser() {
        List<Objects> list = objectsRepository.getObjectsByIdUsers(authLoginService.getAuth().getId());
        List<ObjectDto> response = list.stream().map(el ->
                new ObjectDto(languageCommon.getMessageProperties(el.getKey()), el.getIcons(), el.getUrl()))
        .collect(Collectors.toList());
        return response;
    }
}
