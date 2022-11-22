package com.demoLibrary.demo.controller;

import com.demoLibrary.demo.business.abstracts.AuthorService;
import com.demoLibrary.demo.dtos.author.request.AuthorRequest;
import com.demoLibrary.demo.dtos.author.response.AuthorListResponse;
import com.demoLibrary.demo.dtos.author.response.AuthorResponse;
import com.demoLibrary.demo.entity.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorListResponse>> getAll() {
        List<AuthorListResponse> authorListResponses = authorService.getAll();
        if (authorListResponses.isEmpty()) {
            ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(authorListResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getById(@PathVariable Long id) {
        AuthorResponse authorResponse = authorService.getById(id);
        if (Objects.nonNull(authorResponse)) {
            return new ResponseEntity<>(authorResponse, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> add(@RequestBody AuthorRequest authorRequest) throws Exception {
        AuthorResponse authorResponse = authorService.add(authorRequest);
        if (Objects.nonNull(authorResponse)) {
            return new ResponseEntity<>(authorResponse, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> update(@PathVariable Long id, @RequestBody Author author) {
        AuthorResponse authorResponse = authorService.update(id, author);
        if (Objects.nonNull(authorResponse)) {
            return new ResponseEntity<>(authorResponse, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
