package com.example.corebase.core.base.model;

import com.example.corebase.infrastructure.constant.PaginationConstant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
public abstract class PageableRequest {

    private int page = PaginationConstant.DEFAULT_PAGE;
    private int size = PaginationConstant.DEFAULT_SIZE;
    private int orderBy = 0;

    public Pageable getPageable() {
        return PageRequest.of(page, size);
    }
}
