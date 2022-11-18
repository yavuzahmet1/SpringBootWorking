package com.demoLibrary.demo.core.utils;

import com.demoLibrary.demo.dtos.book.response.BookListResponse;
import com.demoLibrary.demo.dtos.book.response.BookResponse;
import com.demoLibrary.demo.entity.Book;

public class BookModel {
    public static BookListResponse toBookListResponse(Book book) {
        BookListResponse bookListResponse = new BookListResponse();
        bookListResponse.setId(book.getId());
        bookListResponse.setName(book.getName());
        bookListResponse.setPageCount(book.getPageCount());
        return bookListResponse;
    }
    public static BookResponse toBookResponse(Book book){
        BookResponse bookResponse=new BookResponse();
        bookResponse.setId(book.getId());
        bookResponse.setName(book.getName());
        bookResponse.setPageCount(book.getPageCount());
        if (book.getAuthor()!=null){
            bookResponse.setId(book.getAuthor().getId());
        }
        return bookResponse;
    }

}
