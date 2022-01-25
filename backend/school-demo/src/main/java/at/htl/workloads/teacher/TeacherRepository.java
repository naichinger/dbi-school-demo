package at.htl.workloads.teacher;

import java.util.List;

public interface TeacherRepository {
    List<Teacher> findAll();

    Teacher findById(long id);

    void add(Teacher teacher);

    void remove(Teacher teacher);

    Teacher update(Teacher teacher);
}
