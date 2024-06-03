package com.example.corebase.core.superAdmin.informationManagement.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuPremiumTypeCreateRequest {

    private UUID id;

    private String name;

    private String code;

    private BigDecimal money;

    private String note;

    private Long level;

    private UUID roleId;

    private String status;

    private String type;

    private String isDefault;

    private String urlNote;

    private List<UUID> objectGroup;
}
