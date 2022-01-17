package at.htl.workloads.classroom;

import java.util.List;

public interface ClassroomRepository {
    List<Classroom> findAll();
    Classroom findById(long id);
    void add(Classroom classroom);
    void remove(Classroom classroom);
    Classroom update(Classroom classroom);
}
