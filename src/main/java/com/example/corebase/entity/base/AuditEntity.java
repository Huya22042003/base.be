package com.example.corebase.entity.base;

import com.example.corebase.infrastructure.constant.ActiveStatus;
import com.example.corebase.infrastructure.listener.AuditEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditEntityListener.class)
public abstract class AuditEntity {

    @Column(updatable = false)
    private ActiveStatus isActive;

    @Column(updatable = false)
    private Long createdDate;

    @Column
    private Long lastModifiedDate;

    @Column(updatable = false)
    private String createdBy;

    @Column
    private String lastModifiedBy;
}
