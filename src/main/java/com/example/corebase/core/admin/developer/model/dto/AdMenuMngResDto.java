package com.example.corebase.core.admin.developer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdMenuMngResDto {

    private String id;

    private String name;

    private String parent;

    private String module;

    private String useYnCd;

    private String useYn;

    private String url;
}
