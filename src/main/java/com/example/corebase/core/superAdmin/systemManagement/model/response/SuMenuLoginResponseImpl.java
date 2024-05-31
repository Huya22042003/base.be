package com.example.corebase.core.superAdmin.systemManagement.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class SuMenuLoginResponseImpl {

    private UUID id;

    private String code;

    private String name;

    private String url;

    private String icon;

    private List<SuMenuLoginResponseImpl> childId;

    private UUID parentId;

    private Long orderBy;

    private String type;

    public SuMenuLoginResponseImpl(UUID id, String code, String name, String url, String icon, List<SuMenuLoginResponseImpl> childId, Long orderBy, UUID parentId, String type) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.childId = childId;
        this.orderBy = orderBy;
        this.parentId = parentId;
        this.type = type;
    }
}
