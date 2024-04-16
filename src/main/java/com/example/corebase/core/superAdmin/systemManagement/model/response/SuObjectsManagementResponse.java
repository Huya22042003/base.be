package com.example.corebase.core.superAdmin.systemManagement.model.response;

import com.example.corebase.entity.base.IsIdentified;

public interface SuObjectsManagementResponse extends IsIdentified {

    String getCode();

    String getName();

    String getKey();

    String getType();

    Long getIsStart();
}
