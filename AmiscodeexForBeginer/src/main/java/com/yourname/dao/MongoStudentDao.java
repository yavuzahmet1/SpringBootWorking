package com.yourname.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.yourname.entity.Student;

@Repository
@Qualifier("mongoData")
public class MongoStudentDao implements StudentDaoImpl {

	@Override
	public Collection<Student> getAllStudents() {
		return new ArrayList<Student>() {
			{
				add(new Student(1, "Asambalonga", "Bogazici"));
				add(new Student(2, "Yunus", "GS"));
				add(new Student(1, "Talha", "Beşiktaş"));
				add(new Student(1, "Dyzuba", "ADS"));
			}
		};
	}

	@Override
	public Student getStudentById(int id) {
		return null;
	}

	@Override
	public Student removeStudentById(int id) {
		return null;
	}

	@Override
	public void updateStudent(Student student) {

	}

	@Override
	public void insertStudentToDb(Student student) {

	}
}
