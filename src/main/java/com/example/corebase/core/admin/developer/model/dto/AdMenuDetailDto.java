package com.example.corebase.core.admin.developer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdMenuDetailDto {

    private String id;

    private String url;

    private String icon;

    private String name;

    private String parentId;

    private String useYn;

    private String module;

    private String orderBy;

    private String keyLang;

    private String type;
}
