package com.javatechie.controller;

import com.javatechie.entity.Course;
import com.javatechie.entity.Student;
import com.javatechie.repository.CourseRepository;
import com.javatechie.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public Student saveStudentWithCourse(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("{studentId}")
    public Student findStudent(@PathVariable int studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @GetMapping("/find/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name) {
        return studentRepository.findByNameContaining(name);
    }

    @GetMapping("/search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable double price) {
        return courseRepository.findByFeeLessThan(price);
    }
}
