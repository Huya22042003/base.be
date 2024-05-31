package com.example.corebase.core.superAdmin.systemManagement.model.request;

import jakarta.persistence.Column;
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
public class SuObjectGroupRequest {

    private UUID id;

    private String code;

    private String name;

    private String subName;

    private String urlNote;

    private Long orderBy;

    private String status;

    private UUID roleId;

    private UUID moduleId;

    private List<UUID> object;
}
