package at.htl.workloads.student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(Long id);
    List<Student> findByIds(List<Long> studentIds);
    Student update(Student student);
}
