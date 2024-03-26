package com.example.corebase.core.superAdmin.systemManagement.model.request;

import com.example.corebase.core.base.model.PageableRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObjectManagementFilterRequest extends PageableRequest {
    private String code = "";

    private String name = "";

    private String typeObjects;
}
