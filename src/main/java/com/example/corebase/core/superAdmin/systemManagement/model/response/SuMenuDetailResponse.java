package com.example.corebase.core.superAdmin.systemManagement.model.response;

import org.springframework.beans.factory.annotation.Value;

public interface SuMenuDetailResponse {

    @Value("#{target.id}")
    Long getId();

    @Value("#{target.code}")
    String getCode();

    @Value("#{target.name}")
    String getName();

    @Value("#{target.key}")
    String getKey();

    @Value("#{target.url}")
    String getUrl();

    @Value("#{target.icons}")
    String getIcons();

    @Value("#{target.is_start}")
    String getIsStart();

    @Value("#{target.is_active}")
    String getIsActive();

    @Value("#{target.parent_id}")
    Long getParentId();

    @Value("#{target.type}")
    String getType();

    @Value("#{target.order_by}")
    String getOrderBy();
}
