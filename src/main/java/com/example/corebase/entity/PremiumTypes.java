package com.example.corebase.entity;

import com.example.corebase.entity.base.PrimaryBase;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PremiumTypes extends PrimaryBase {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "money")
    private BigDecimal money;

    @Column(name = "is_active")
    private ActiveStatus isActive;

    @Column(name = "note")
    private String note;

    @Column(name = "level")
    private Long level;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles rolesId;

}
