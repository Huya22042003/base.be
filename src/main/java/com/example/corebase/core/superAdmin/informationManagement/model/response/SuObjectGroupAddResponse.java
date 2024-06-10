package com.example.corebase.core.superAdmin.informationManagement.model.response;

import com.example.corebase.entity.base.IsIdentified;

public interface SuObjectGroupAddResponse extends IsIdentified {

    String getCode();

    String getName();

    String getSubName();

    String getStatus();
}
