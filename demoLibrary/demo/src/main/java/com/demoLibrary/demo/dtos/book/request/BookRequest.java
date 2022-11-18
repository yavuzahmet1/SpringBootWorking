package com.demoLibrary.demo.dtos.book.request;

import lombok.Data;

@Data
public class BookRequest {
    private String name;
    private int pageCount;
    private Long authorId;
}
