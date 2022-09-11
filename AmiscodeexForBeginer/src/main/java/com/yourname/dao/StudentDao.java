package com.yourname.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.yourname.entity.Student;

@Repository
@Qualifier("fakeData")
public class StudentDao implements StudentDaoImpl {

	private static Map<Integer, Student> students;

	static {
		students = new HashMap<Integer, Student>() {
			{
				put(1, new Student(1, "Said", "Computer Science"));
				put(2, new Student(2, "Ahmet", "Computer Science"));
				put(3, new Student(3, "Yavuz", "Computer Science"));
				put(4, new Student(4, "Kaya", "Computer Enginer"));
				put(5, new Student(5,
						"Erdoğan’ın açıklamaları sonrasında tetikteler: Yunanistan Cumhurbaşkanı’ndan manidar ziyaret",
						"Bu yılın Mayıs ayına kadar ilişkilerin yolunda seyrettiği Ankara-Atina hattında tansiyon düşmek bilmiyor... Cumhurbaşkanı Erdoğan'ın Yunanistan'a yönelik açıklamalarını sertleştirdiği bir dönemde Yunanistan lideri Sakellaropoulou'dan \"zamanlaması manidar\" bir ziyaret hamlesi geldi."));
			}
		};
	}

	@Override
	public Collection<Student> getAllStudents() {
		return students.values();
	}

	@Override
	public Student getStudentById(int id) {
		return students.get(id);
	}

	@Override
	public Student removeStudentById(int id) {
		return students.remove(id);
	}

	@Override
	public void updateStudent(Student student) {
		Student s = students.get(student.getId());
		s.setCourse(student.getCourse());
		s.setName(student.getName());
		students.put(student.getId(), student);
	}

	@Override
	public void insertStudentToDb(Student student) {
		students.put(student.getId(), student);
	}
}
