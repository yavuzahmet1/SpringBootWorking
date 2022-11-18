package com.demoLibrary.demo.business.abstracts;

import com.demoLibrary.demo.dtos.author.request.AuthorRequest;
import com.demoLibrary.demo.dtos.author.response.AuthorListResponse;
import com.demoLibrary.demo.dtos.author.response.AuthorResponse;
import com.demoLibrary.demo.dtos.book.response.BookListResponse;
import com.demoLibrary.demo.entity.Author;

import java.util.List;

public interface AuthorService {
    List<AuthorListResponse> getAll();
    AuthorResponse getById(Long id);
    AuthorResponse add(AuthorRequest authorRequest);
    AuthorResponse update(Long id,Author author);
    void delete(Long id);
    AuthorResponse toAuthorResponse(Author author);
    AuthorListResponse toAuthorListResponse(Author author);
    Author getAuthorById(Long id);
    List<BookListResponse> getAuthorBookList(Long id);

}
