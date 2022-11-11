package com.javatechie.repository;

import com.javatechie.entity.Course;
import com.javatechie.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    List<Course> findByFeeLessThan(Double fee);
}
