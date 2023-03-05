package com.validation.validationexample.controller;

import com.validation.validationexample.Service.StudentService;
import com.validation.validationexample.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> addStudent(Student student) {
        studentService.add(student);
        return ResponseEntity.ok(student + " Student saved");
    }

    @GetMapping("/getir")
    public ResponseEntity<String> get(Long id) {
        studentService.get(id);
        return ResponseEntity.ok(id + " student");
    }
}
