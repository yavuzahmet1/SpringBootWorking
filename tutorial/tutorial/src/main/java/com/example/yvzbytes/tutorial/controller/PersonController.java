package com.example.yvzbytes.tutorial.controller;

import com.example.yvzbytes.tutorial.dto.PersonDto;
import com.example.yvzbytes.tutorial.service.abstracts.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> add(@RequestBody PersonDto personDto){
        return ResponseEntity.ok(personService.save(personDto));
    }
    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll(){
        return ResponseEntity.ok(personService.getAll());
    }
}
