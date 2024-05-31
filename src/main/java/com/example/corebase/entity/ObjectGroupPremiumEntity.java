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

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DynamicUpdate
@Table(name = "objects_group_premiums")
public class ObjectGroupPremiumEntity extends PrimaryBase {

    @Column(name = "object_id")
    private UUID objectGroupId;

    @Column(name = "premium_id")
    private UUID premiumId;
}
