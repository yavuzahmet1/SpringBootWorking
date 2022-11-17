package com.demoLibrary.demo.dtos.book.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookListResponse {
    private Long id;
    private String name;
    private int pageCount;
    private Long aouthorId;

}
