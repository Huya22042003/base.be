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
@Table(name = "staff_object_entity")
public class StaffObjectEntity extends PrimaryBase {

    @Column(name = "staff_id")
    private UUID staffId;

    @Column(name = "object_group_id")
    private UUID objectGroupId;
}
