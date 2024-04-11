package com.example.corebase.core.superAdmin.systemManagement.model.response;

import org.springframework.beans.factory.annotation.Value;

public interface SuMenuParentResponse {

    @Value("#{target.id}")
    Long getId();

    @Value("#{target.code}")
    String getCode();

    @Value("#{target.name}")
    String getName();

    @Value("#{target.key}")
    String getKey();
}
