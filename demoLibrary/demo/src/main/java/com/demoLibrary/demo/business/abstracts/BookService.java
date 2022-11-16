package com.demoLibrary.demo.business.abstracts;

import com.demoLibrary.demo.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    Book getById(Long id);

    Book add(Book book);

    Book update(Book book, Long id);

    void delete(Long id);

}
