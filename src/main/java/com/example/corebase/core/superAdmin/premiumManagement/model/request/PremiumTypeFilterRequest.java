package com.example.corebase.core.superAdmin.premiumManagement.model.request;

import com.example.corebase.core.base.model.PageableRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PremiumTypeFilterRequest extends PageableRequest {

    private String code;

    private String name;
}
