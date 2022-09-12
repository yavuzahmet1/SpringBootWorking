package com.yourname.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yourname.entity.Student;
import com.yourname.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Student> getAllStudents() {

		return studentService.getAllStudents();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getStudentGetById(@PathVariable("id") int id) {

		return studentService.getStudentById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Student deleteStudentById(@PathVariable("id") int id) {

		return studentService.removeStudentById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateStudentById(@RequestBody Student student) {

		studentService.updateStudent(student);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertStudent(@RequestBody Student student) {

		studentService.insertStudent(student);
	}

}
