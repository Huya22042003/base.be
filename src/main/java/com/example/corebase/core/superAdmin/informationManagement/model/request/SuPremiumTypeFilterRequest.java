package com.example.corebase.core.superAdmin.informationManagement.model.request;

import com.example.corebase.core.base.model.PageableRequest;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class SuPremiumTypeFilterRequest extends PageableRequest {

    private String code;

    private String name;

    private UUID roleId;

    private BigDecimal moneyEnd;

    private BigDecimal moneyStart;

    private String status;

    private String isDefault;

    private String type;

    private String note;
}
