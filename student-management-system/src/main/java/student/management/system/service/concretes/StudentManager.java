package student.management.system.service.concretes;

import org.springframework.stereotype.Service;
import student.management.system.entity.Student;
import student.management.system.repository.StudentRepository;
import student.management.system.service.abstracts.StudentService;

import java.util.List;

@Service
public class StudentManager implements StudentService {
    private final StudentRepository studentRepository;

    public StudentManager(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
