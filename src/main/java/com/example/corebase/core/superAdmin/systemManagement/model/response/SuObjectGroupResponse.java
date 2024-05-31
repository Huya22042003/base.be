package com.example.corebase.core.superAdmin.systemManagement.model.response;

import com.example.corebase.entity.base.IsIdentified;

public interface SuObjectGroupResponse extends IsIdentified {

    String getCode();

    String getName();

    String getSubName();

    String getUrlNote();

    String getStatus();

    Long getOrderBy();

    String getRoleName();

    String getModuleName();
}
