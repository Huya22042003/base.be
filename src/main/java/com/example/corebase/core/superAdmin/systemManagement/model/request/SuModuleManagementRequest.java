package com.example.corebase.core.superAdmin.systemManagement.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuModuleManagementRequest {

    private UUID id;

    private String code;

    private String name;

    private String url;

    private String note;

    private String status;
}
