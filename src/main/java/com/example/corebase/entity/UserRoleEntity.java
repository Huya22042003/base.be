package com.example.corebase.entity;

import com.example.corebase.entity.base.PrimaryBase;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_roles")
public class UserRoleEntity extends PrimaryBase {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity userId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RolesEntity rolesEntityId;

    @Column(name = "is_active")
    private ActiveStatus isActive;
}
