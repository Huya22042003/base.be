package com.example.corebase.entity.base;

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
    private Date createdDate;

    @Column
    private Date lastModifiedDate;

    @Column(updatable = false)
    private Long createdBy;

    @Column
    private Long lastModifiedBy;
}
