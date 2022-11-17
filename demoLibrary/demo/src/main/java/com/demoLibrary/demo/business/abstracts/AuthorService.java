package com.demoLibrary.demo.business.abstracts;

import com.demoLibrary.demo.dtos.author.response.AuthorListResponse;
import com.demoLibrary.demo.dtos.author.response.AuthorResponse;
import com.demoLibrary.demo.entity.Author;

import java.util.List;

public interface AuthorService {
    List<AuthorListResponse> getAll();
    AuthorResponse getById(Long id);
    AuthorResponse add(Author author);
    AuthorResponse update(Long id,Author author);
    void delete(Long id);

}
