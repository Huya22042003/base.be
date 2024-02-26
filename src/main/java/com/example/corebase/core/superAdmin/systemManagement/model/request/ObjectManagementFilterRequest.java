package com.example.corebase.core.superAdmin.systemManagement.model.request;

import com.example.corebase.core.base.model.PageableRequest;
import com.example.corebase.infrastructure.constant.TypeObjects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObjectManagementFilterRequest extends PageableRequest {
    private String code;

    private String name;

    private TypeObjects typeObjects;
}
