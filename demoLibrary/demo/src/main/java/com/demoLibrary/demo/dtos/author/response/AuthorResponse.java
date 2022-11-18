package com.demoLibrary.demo.dtos.author.response;

import com.demoLibrary.demo.dtos.book.response.BookListResponse;
import lombok.Data;
import java.util.List;

@Data
public class AuthorResponse {
    private Long id;
    private String name;
}
