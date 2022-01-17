package at.htl.workloads.classroom;

import at.htl.model.ClassroomDTO;

import java.net.URI;
import java.time.DayOfWeek;
import java.util.List;

public interface ClassroomService {
    List<Classroom> findAll();

    Classroom findById(long id);

    Classroom addClassroom(String name, Long teacherId, Long roomId, List<Long> studentIds, List<Long> lessonIds, List<Long> testIds);

    void removeClassroom(Classroom classroom);

    Classroom updateClassroom(Classroom classroom, String name, Long teacherId, Long roomId, List<Long> studentIds, List<Long> lessonIds, List<Long> testIds);

    List<ClassroomLesson> getLessonsForDayOfWeek(Classroom classroom, DayOfWeek dayOfWeek);
}
