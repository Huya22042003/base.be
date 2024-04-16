package com.example.corebase.core.superAdmin.systemManagement.model.response;

import com.example.corebase.entity.base.IsIdentified;
import com.example.corebase.infrastructure.constant.ActiveStatus;

public interface SuRolesManagementResponse extends IsIdentified {

    String getRoleName();

    String getRoleCode();

    ActiveStatus getIsActive();
}
