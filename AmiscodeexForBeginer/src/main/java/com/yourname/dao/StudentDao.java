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
				put(5,new Student(5,"Erdoğan’ın açıklamaları sonrasında tetikteler: Yunanistan Cumhurbaşkanı’ndan manidar ziyaret","Bu yılın Mayıs ayına kadar ilişkilerin yolunda seyrettiği Ankara-Atina hattında tansiyon düşmek bilmiyor... Cumhurbaşkanı Erdoğan'ın Yunanistan'a yönelik açıklamalarını sertleştirdiği bir dönemde Yunanistan lideri Sakellaropoulou'dan \"zamanlaması manidar\" bir ziyaret hamlesi geldi."));
			}
		};
	}

	public Collection<Student> getAllStudents() {
		return students.values();
	}

	public Student getStudentById(int id){
		return this.students.get(id);
	}

	public void removeStudentById(int id) {
		this.students.remove(id);
	}

	public void updateStudent(Student student){
		Student s =students.get(student.getId());
		s.setCourse(student.getCourse());
		s.setName(student.getName());
		students.put(student.getId(),student);
	}
	private void insertStudentToDb(Student student) {
		this.students.put(student.getId(), student);
	}
}
