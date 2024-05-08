package com.example.corebase.entity;

import com.example.corebase.entity.base.PrimaryBase;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DynamicUpdate
@Table(name = "staff_entity")
public class StaffEntity extends PrimaryBase {

    @Column(name = "username")
    private String staffName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "is_active")
    private ActiveStatus isActive;
}
