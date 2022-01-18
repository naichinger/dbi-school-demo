package at.htl.workloads.student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findByIds(List<Long> studentIds) {
        List<Student> students = new ArrayList<>();
        studentIds.forEach((id) -> students.add(studentRepository.findById(id)));
        return students;
    }

    @Override
    public Student update(Student student) {
        return studentRepository.update(student);
    }
}
