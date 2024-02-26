package com.example.corebase.core.superAdmin.systemManagement.model.response;

import org.springframework.beans.factory.annotation.Value;

public interface MenuLoginResponse {

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

    @Value("#{target.parent_id}")
    Long getParentId();

    @Value("#{target.order_by}")
    Long getOrderBy();

}
