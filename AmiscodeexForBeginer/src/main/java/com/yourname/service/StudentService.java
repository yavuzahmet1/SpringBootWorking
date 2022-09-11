package com.yourname.service;

import java.util.Collection;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import com.yourname.dao.StudentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yourname.dao.StudentDao;
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
        return this.studentDaoImp.getStudentById(id);
    }

    public void removeStudentById(int id) {
        this.studentDaoImp.removeStudentById(id);
    }

    public void updateStudent(Student student) {
        this.studentDaoImp.updateStudent(student);
    }


    public void insertStudent(Student student) {
        studentDaoImp.insertStudentToDb(student);
    }
}
