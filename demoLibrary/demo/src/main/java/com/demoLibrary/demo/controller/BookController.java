package com.demoLibrary.demo.controller;

import com.demoLibrary.demo.business.abstracts.BookService;
import com.demoLibrary.demo.dtos.book.request.BookRequest;
import com.demoLibrary.demo.dtos.book.response.BookListResponse;
import com.demoLibrary.demo.dtos.book.response.BookResponse;
import com.demoLibrary.demo.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;
    private final AuthorController authorController;

    public BookController(BookService bookService, AuthorController authorController) {
        this.bookService = bookService;
        this.authorController = authorController;
    }

    @GetMapping
    public ResponseEntity<List<BookListResponse>> getAll() {
        List<BookListResponse> bookListResponses = bookService.getAll();
        if (bookListResponses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(bookListResponses, HttpStatus.OK);
    }

    @GetMapping("{id}") //example.com/1 anlamında
    public ResponseEntity<BookResponse> getById(@PathVariable Long id) {//PathVariable
        BookResponse bookResponse=bookService.getById(id);
        if (Objects.nonNull(bookResponse)) {
            return new ResponseEntity<>(bookResponse, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest bookRequest) {
        BookResponse bookResponse = bookService.add(bookRequest);
        if (Objects.nonNull(bookResponse)) {
            return new ResponseEntity<>(bookResponse, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @RequestBody Book book) {
        BookResponse bookResponse = bookService.update(book, id);
        if (Objects.nonNull(bookResponse)) {
            return new ResponseEntity<>(bookResponse, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }

}
