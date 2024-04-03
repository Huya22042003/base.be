package com.example.corebase.core.base.model;

import com.example.corebase.infrastructure.constant.PaginationConstant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public abstract class PageableRequest {

    private int current = PaginationConstant.DEFAULT_PAGE;
    private int size = PaginationConstant.DEFAULT_SIZE;
    private String sortField = "id";
    private String sortType = "";
}
