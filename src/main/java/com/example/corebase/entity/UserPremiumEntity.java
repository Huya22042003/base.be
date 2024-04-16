package com.example.corebase.entity;

import com.example.corebase.entity.base.PrimaryBase;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@DynamicUpdate
@Table(name = "users_premiums")
public class UserPremiumEntity extends PrimaryBase {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity usersEntityId;

    @ManyToOne
    @JoinColumn(name = "premium_id")
    private PremiumTypesEntity premiumTypesEntity;

    @Column(name = "is_active")
    private ActiveStatus isActive;
}
