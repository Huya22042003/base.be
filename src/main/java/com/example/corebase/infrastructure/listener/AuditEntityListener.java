package com.example.corebase.infrastructure.listener;

import com.example.corebase.entity.base.AuditEntity;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.Date;

public class AuditEntityListener {

    @PrePersist
    private void onCreate(AuditEntity entity) {
        entity.setCreatedDate(getCurrentTime().getTime());
        entity.setLastModifiedDate(getCurrentTime().getTime());
        entity.setIsActive(ActiveStatus.ACTIVE);
    }

    @PreUpdate
    private void onUpdate(AuditEntity entity) {
        entity.setLastModifiedDate(getCurrentTime().getTime());
    }

    private Date getCurrentTime() {
        return new Date();
    }
}
