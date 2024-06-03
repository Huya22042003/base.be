package com.example.corebase.core.superAdmin.informationManagement.model.response;

import com.example.corebase.entity.base.IsIdentified;

import java.math.BigDecimal;

public interface SuPremiumManagementResponse extends IsIdentified {

    String getCode();

    String getName();

    String getLevel();

    String getRoleName();

    BigDecimal getMoney();

    String getNote();

    String getStatus();

    String getIsDefault();

    String getType();
}
