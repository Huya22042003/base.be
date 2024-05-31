package com.example.corebase.core.superAdmin.systemManagement.model.request;

import com.example.corebase.core.base.model.PageableRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuObjectGroupFilterRequest extends PageableRequest {

    private String code;

    private String name;

    private String subName;

    private UUID roleId;

    private UUID moduleId;

    private String status;
}
