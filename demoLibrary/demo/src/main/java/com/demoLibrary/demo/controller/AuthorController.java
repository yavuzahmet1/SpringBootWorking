package com.demoLibrary.demo.controller;

import com.demoLibrary.demo.business.abstracts.AuthorService;
import com.demoLibrary.demo.entity.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAll() {
        List<Author> authorList = authorService.getAll();
        if (authorList.isEmpty()) {
            ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable Long id) {
        Author author1=authorService.getById(id);
        if (Object.nonNull(author1)){
            return new ResponseEntity<>(author1,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        authorService.delete(id);
    }

    @PostMapping
    public ResponseEntity<Author>add(@ResponseBody Author author){
        Author author1=authorService.add(author);
        if (Object.nonNull(author1)){
            return new ResponseEntity<>(author1,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("{id}/{bookId}")
    public ResponseEntity<Author> update(@PathVariable Long id,@RequestBody Author author){
        Author author1=authorService.update()
    }
}
