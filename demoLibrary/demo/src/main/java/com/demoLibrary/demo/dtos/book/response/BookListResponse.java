package com.demoLibrary.demo.dtos.book.response;

import lombok.Data;

@Data
public class BookListResponse {
    private Long id;
    private String name;
    private int pageCount;

}
