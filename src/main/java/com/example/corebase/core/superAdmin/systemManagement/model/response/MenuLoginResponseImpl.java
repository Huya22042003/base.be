package com.example.corebase.core.superAdmin.systemManagement.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MenuLoginResponseImpl {

    private Long id;

    private String code;

    private String name;

    private String url;

    private List<MenuLoginResponseImpl> childId;

    private Long parentId;

    private Long orderBy;

    public MenuLoginResponseImpl(Long id, String code, String name, String url, List<MenuLoginResponseImpl> childId, Long orderBy, Long parentId) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.url = url;
        this.childId = childId;
        this.orderBy = orderBy;
        this.parentId = parentId;
    }
}
