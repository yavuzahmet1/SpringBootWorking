package com.yourname.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yourname.dao.StudentDao;
import com.yourname.dao.StudentDaoImpl;
import com.yourname.entity.Student;

@Service
public class StudentService {

	@Autowired
	@Qualifier("mongoData")
	private StudentDaoImpl studentDaoImp;

	public StudentService(StudentDao studentDaoImp) {
		super();
		this.studentDaoImp = studentDaoImp;
	}

	public Collection<Student> getAllStudents() {
		return studentDaoImp.getAllStudents();
	}

	public Student getStudentById(int id) {
		return studentDaoImp.getStudentById(id);
	}

	public Student removeStudentById(int id) {
		return studentDaoImp.removeStudentById(id);
	}

	public void updateStudent(Student student) {
		studentDaoImp.updateStudent(student);
	}

	public void insertStudent(Student student) {
		studentDaoImp.insertStudentToDb(student);
	}
}
