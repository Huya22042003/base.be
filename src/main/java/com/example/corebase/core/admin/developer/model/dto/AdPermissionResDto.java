package com.example.corebase.core.admin.developer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdPermissionResDto {

    private String id;

    private String roleNm;

    private String name;

    private String defaultNm;

    private String useNm;
}
