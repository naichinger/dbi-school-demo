package at.htl.workloads.student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(Long studentIds);
    Student update(Student student);
}
