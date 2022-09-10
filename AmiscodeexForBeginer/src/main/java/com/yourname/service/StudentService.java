package com.yourname.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourname.dao.StudentDao;
import com.yourname.entity.Student;

@Service
public class StudentService {

	private StudentDao studentDao;

	@Autowired
	public StudentService(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	public Collection<Student> getAllStudents() {

		return studentDao.getAllStudents();
	}
}
