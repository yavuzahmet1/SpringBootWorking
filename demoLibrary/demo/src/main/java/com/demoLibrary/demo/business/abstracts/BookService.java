package com.demoLibrary.demo.business.abstracts;

import com.demoLibrary.demo.dtos.book.response.BookListResponse;
import com.demoLibrary.demo.dtos.book.response.BookResponse;
import com.demoLibrary.demo.entity.Book;

import java.util.List;

public interface BookService {

    List<BookListResponse> getAll();

    BookResponse getById(Long id);

    BookResponse add(Book book);

    BookResponse update(Book book, Long id);

    void delete(Long id);

}
