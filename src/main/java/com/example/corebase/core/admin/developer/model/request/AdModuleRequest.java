package com.example.corebase.core.admin.developer.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdModuleRequest {

    private String id;

    private String code;

    private String name;

    private String note;

    private String token;

    private String useYn;
}
