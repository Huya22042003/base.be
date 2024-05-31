package com.example.corebase.core.superAdmin.systemManagement.model.request;

import com.example.corebase.entity.base.IsIdentifiedRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuRolesManagementRequest extends IsIdentifiedRequest {

    private String roleCode;
    private String roleName;
    private List<UUID> object;
}
