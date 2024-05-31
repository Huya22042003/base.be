package com.example.corebase.core.superAdmin.systemManagement.model.request;

import com.example.corebase.core.base.model.PageableRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuModuleFilterRequest extends PageableRequest {

    private String code;

    private String name;

    private String url;

    private String note;

    private String status;
}
