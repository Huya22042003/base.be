package com.example.corebase.entity;

import com.example.corebase.entity.base.PrimaryBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DynamicUpdate
@Table(name = "premium_type")
public class PremiumTypesEntity extends PrimaryBase {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "money")
    private BigDecimal money;

    @Column(name = "note")
    private String note;

    @Column(name = "type")
    private String type;

    @Column(name = "is_default")
    private String isDefault;

    @Column(name = "url_note")
    private String urlNote;

    @Column(name = "level")
    private Long level;

    @Column(name = "role_id")
    private UUID rolesEntityId;

    @Column(name = "status")
    private String status;
}
