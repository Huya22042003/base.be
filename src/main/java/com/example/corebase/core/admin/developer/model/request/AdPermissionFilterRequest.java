package com.example.corebase.core.admin.developer.model.request;

import com.example.corebase.core.base.model.PageableRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdPermissionFilterRequest extends PageableRequest {

    private String name;

    private String roleId;

    private String moduleId;

    private String defaultYn;

    private String useYn;
}
