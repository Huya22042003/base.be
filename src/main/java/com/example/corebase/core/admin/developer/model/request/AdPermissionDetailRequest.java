package com.example.corebase.core.admin.developer.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdPermissionDetailRequest {

    private String id;

    private String menuId;

    private String apiId;

    private String permissionId;

    private String type;
}
