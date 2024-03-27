package com.example.corebase.core.superAdmin.systemManagement.model.response;

import org.springframework.beans.factory.annotation.Value;

public interface SuObjectsManagementResponse {

    @Value("#{target.stt}")
    Long getStt();

    @Value("#{target.id}")
    Long getId();

    @Value("#{target.code}")
    String getCode();

    @Value("#{target.name}")
    String getName();

    @Value("#{target.key}")
    String getKey();

    @Value("#{target.type}")
    String getType();

    @Value("#{target.is_start}")
    Long getIsStart();
}
