package com.demoLibrary.demo.controller;

import com.demoLibrary.demo.business.abstracts.BookService;
import com.demoLibrary.demo.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll(){
        List<Book> bookList=bookService.getAll();
        if (bookList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("{id}") //example.com/1 anlamında
    public ResponseEntity<Book> getById(@PathVariable Long id){//PathVariable
        Book book=bookService.getById(id);
        if (Objects.nonNull(book)){
            return new ResponseEntity<>(book,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book book1=bookService.add(book);
        if (Objects.nonNull(book1)){
            return new ResponseEntity<>(book1,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
