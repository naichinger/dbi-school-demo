package at.htl.workloads.classroom;

import at.htl.model.ClassroomDTO;
import at.htl.model.StudentCountDTO;
import at.htl.model.TeacherHourCountDTO;

import java.net.URI;
import java.time.DayOfWeek;
import java.util.List;

public interface ClassroomService {
    List<Classroom> findAll();

    Classroom findById(long id);

    Classroom addClassroom(String name, Long teacherId, Long roomId, List<Long> studentIds);

    void removeClassroom(Classroom classroom);

    Classroom updateClassroom(Classroom classroom, String name, Long teacherId, Long roomId, List<Long> studentIds);

    Classroom updateClassroom(Classroom classroom);

    List<ClassroomLesson> getLessonsForDayOfWeek(Classroom classroom, DayOfWeek dayOfWeek);

    List<Lesson> findAllLessons();

    void addClassroomLesson(ClassroomLesson classroomLesson);

    List<TeacherHourCountDTO> getTeacherWithStudentsCount(Long TeacherId);

    List<StudentCountDTO> getClassWithStudentCount();
}
