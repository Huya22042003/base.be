package com.example.corebase.core.admin.developer.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdPermissionRequest {

    private String id;

    private String roleId;

    private String moduleId;

    private String name;

    private String note;

    private String defaultYn;

    private String useYn;

    private List<AdPermissionDetailRequest> detail;
}
