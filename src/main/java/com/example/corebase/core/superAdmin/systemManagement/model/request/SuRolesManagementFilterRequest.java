package com.example.corebase.core.superAdmin.systemManagement.model.request;

import com.example.corebase.core.base.model.PageableRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SuRolesManagementFilterRequest extends PageableRequest {
    private String code = "";
    private String name = "";
}
