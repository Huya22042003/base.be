package com.example.corebase.core.superAdmin.systemManagement.model.request;

import com.example.corebase.entity.base.IsIdentifiedRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuRolesManagementDetailRequest extends IsIdentifiedRequest {

    private String roleCode;

    private String roleName;

    private List<SuRolesObjectDetailRequest> rolesObjectDetailRequests;

}
