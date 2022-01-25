package at.htl.workloads.teacher;

import at.htl.workloads.classroom.Classroom;

import java.math.BigDecimal;
import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    Teacher findById(long id);

    Teacher addTeacher(String firstname, String lastname, BigDecimal salary);

    void removeTeacher(Teacher teacher);

    Teacher updateTeacher(Teacher teacher, String firstname, String lastname, BigDecimal salary);
}
