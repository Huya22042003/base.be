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

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "user_object")
public class UserObject extends PrimaryBase {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userid;

    @ManyToOne
    @JoinColumn(name = "object_id")
    private Objects objectId;

    @Column(name = "is_active")
    private ActiveStatus isActive;
}
