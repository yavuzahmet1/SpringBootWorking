package com.demoLibrary.demo.dtos.book.response;

import com.demoLibrary.demo.dtos.author.response.AuthorResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Long id;
    private String name;
    private int pageCount;
    private List<AuthorResponse> bookId;
}
