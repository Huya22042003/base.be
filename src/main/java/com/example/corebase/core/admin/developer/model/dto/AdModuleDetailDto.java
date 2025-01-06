package com.example.corebase.core.admin.developer.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdModuleDetailDto {

    private String id;

    private String code;

    private String name;

    private String note;

    private String token;

    private String useYn;
}
