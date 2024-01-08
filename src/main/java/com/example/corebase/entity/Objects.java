package com.example.corebase.entity;

import com.example.corebase.entity.base.PrimaryBase;
import com.example.corebase.infrastructure.constant.ActiveStatus;
import com.example.corebase.infrastructure.constant.TypeObjects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Objects extends PrimaryBase {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "order_by")
    private Long orderBy;

    @Column(name = "icons")
    private String icons;

    @Column(name = "url")
    private String url;

    @Column(name = "is_active")
    private ActiveStatus isActive;

    @Column(name = "type")
    private TypeObjects type;

    @Column(name = "key")
    private String key;
}
