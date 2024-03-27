package com.example.corebase.core.superAdmin.systemManagement.model.request;

import com.example.corebase.core.base.model.PageableRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuObjectManagementFilterRequest extends PageableRequest {

    private String code = "";

    private String name = "";

    private String typeObjects = "";
}
