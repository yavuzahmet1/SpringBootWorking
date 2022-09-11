package com.yourname.dao;

import java.util.Collection;

import com.yourname.entity.Student;

public interface StudentDaoImpl {
	Collection<Student> getAllStudents();

	Student getStudentById(int id);

	Student removeStudentById(int id);

	void updateStudent(Student student);

	void insertStudentToDb(Student student);
}
