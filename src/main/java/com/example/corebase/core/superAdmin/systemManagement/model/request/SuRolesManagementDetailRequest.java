package com.example.corebase.core.superAdmin.systemManagement.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuRolesManagementDetailRequest {

    private String roleCode;

    private String roleName;

    private List<SuRolesObjectDetailRequest> rolesObjectDetailRequests;

}
