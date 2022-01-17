package at.htl.workloads.classroom;

import at.htl.model.ClassroomDTO;

import java.net.URI;
import java.util.List;

public interface ClassroomService {
    List<Classroom> findAll();
    Classroom findById(long id);
    Classroom addClassroom(String name, Long teacherId, Long roomId, List<Long> studentIds);
    void removeClassroom(Classroom classroom);
    Classroom updateClassroom(long id, String name, Long teacherId, Long roomId, List<Long> studentIds);
}
