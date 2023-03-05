package com.validation.validationexample.Service;

import com.validation.validationexample.model.Student;
import com.validation.validationexample.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void add(Student student) {
        studentRepository.save(student);
    }

    public void get(Long id) {
        studentRepository.findAllById(Collections.singleton(id));
    }
}
