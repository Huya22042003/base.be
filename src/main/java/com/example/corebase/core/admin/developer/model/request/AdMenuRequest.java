package com.example.corebase.core.admin.developer.model.request;

import com.example.corebase.entity.base.IsIdentifiedRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdMenuRequest extends IsIdentifiedRequest {

    private String url;

    private String icon;

    private String name;

    private String parentId;

    private String useYn;

    private String module;

    private String keyLang;

    private String orderBy;

    private String type;
}
