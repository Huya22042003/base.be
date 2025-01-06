package com.example.corebase.core.admin.developer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdResourceMngResDto {

    private String id;

    private String api;

    private String name;

    private String role;

    private String useYn;

    private String module;

    private String method;
}
