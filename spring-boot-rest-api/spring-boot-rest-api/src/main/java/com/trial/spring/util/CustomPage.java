package com.trial.spring.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

@Setter
@Getter
public class CustomPage<T> {
    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private Sort sort;
    private int totalPage;
    private long totalElements;

    public CustomPage(Page page, List<T> content) {
        this.content = content;
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
        this.sort = page.getSort();
        this.totalPage = page.getTotalPages();
        this.totalElements = page.getTotalElements();
    }
}
/*Kendi Pagemizi oluşturduk*/