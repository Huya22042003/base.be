package com.example.corebase.core.superAdmin.informationManagement.model.request;

import com.example.corebase.entity.RolesEntity;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
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

    private ActiveStatus status;
}
