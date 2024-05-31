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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicUpdate
@Table(name = "object_groups")
public class ObjectGroups extends PrimaryBase {

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "sub_name")
    private String subName;

    @Column(name = "url_note")
    private String urlNote;

    @Column(name = "order_by")
    private Long orderBy;

    @Column(name = "status")
    private String status;

    @Column(name = "role_id")
    private UUID roleId;

    @Column(name = "module_id")
    private UUID moduleId;
}
