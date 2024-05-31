package com.example.corebase.entity;

import com.example.corebase.entity.base.PrimaryBase;
import com.example.corebase.infrastructure.constant.ActiveStatus;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@Table(name = "objects_entity")
public class ObjectsEntity extends PrimaryBase {

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

    @Column(name = "is_start")
    private ActiveStatus isStart;

    @Column(name = "type")
    private String type;

    @Column(name = "key")
    private String key;

    @Column(name = "parent_id")
    private UUID parentId;
}
