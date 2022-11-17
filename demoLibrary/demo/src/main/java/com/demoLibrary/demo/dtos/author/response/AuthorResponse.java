package com.demoLibrary.demo.dtos.author.response;

import com.demoLibrary.demo.dtos.book.response.BookListResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {
    private Long id;
    private String name;
    private List<BookListResponse> authorId;
}
