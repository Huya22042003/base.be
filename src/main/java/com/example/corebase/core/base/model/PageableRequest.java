package com.example.corebase.core.base.model;

import com.example.corebase.infrastructure.constant.PaginationConstant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PageableRequest {

    private int current = PaginationConstant.DEFAULT_PAGE;
    private int size = PaginationConstant.DEFAULT_SIZE;
    private String sortField = "createdDate";
    private String sortType = "";
}
