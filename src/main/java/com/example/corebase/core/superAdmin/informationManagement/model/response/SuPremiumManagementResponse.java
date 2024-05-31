package com.example.corebase.core.superAdmin.informationManagement.model.response;

import com.example.corebase.entity.base.IsIdentified;

public interface SuPremiumManagementResponse extends IsIdentified {

    String getCode();

    String getName();

    String getLevel();

    String getRoleName();

    String getMoney();

    String getNote();

    String getStatus();
}
