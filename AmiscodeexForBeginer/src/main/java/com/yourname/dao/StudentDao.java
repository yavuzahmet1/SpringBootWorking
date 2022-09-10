package com.yourname.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yourname.entity.Student;

@Repository
public class StudentDao {

	private static Map<Integer, Student> students;

	static {
		students = new HashMap<Integer, Student>() {
			{
				put(1, new Student(1, "Said", "Computer Science"));
				put(2, new Student(2, "Ahmet", "Computer Science"));
				put(3, new Student(3, "Yavuz", "Computer Science"));
				put(4, new Student(4, "Kaya", "Computer Enginer"));
			}
		};
	}

	public Collection<Student> getAllStudents() {

		return students.values();
	}
}
