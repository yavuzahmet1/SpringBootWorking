package com.javatechie.repository;

import com.javatechie.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByNameContaining(String name);
}
