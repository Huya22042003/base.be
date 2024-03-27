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

    private int page = PaginationConstant.DEFAULT_PAGE;
    private int size = PaginationConstant.DEFAULT_SIZE;
    private String orderByColumn;
    private boolean ascendingOrder = true;

    public Pageable getPageable() {
        Sort sort = sort();
        if (sort == null) {
            return PageRequest.of(page, size);
        }
        return PageRequest.of(page, size, sort);
    }

    public Sort sort() {
        if (orderByColumn != null && !orderByColumn.isEmpty()) {
            return ascendingOrder ? Sort.by(Sort.Direction.ASC, orderByColumn) : Sort.by(Sort.Direction.DESC, orderByColumn);
        } else {
            return null;
        }
    }
}
