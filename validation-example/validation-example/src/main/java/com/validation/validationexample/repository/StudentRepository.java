package com.validation.validationexample.repository;

import com.validation.validationexample.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
