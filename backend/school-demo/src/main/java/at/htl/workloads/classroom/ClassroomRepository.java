package at.htl.workloads.classroom;

import at.htl.model.StudentCountDTO;
import at.htl.model.TeacherHourCountDTO;

import java.time.DayOfWeek;
import java.util.List;

public interface ClassroomRepository {
    List<Classroom> findAll();

    Classroom findById(long id);

    void add(Classroom classroom);

    void remove(Classroom classroom);

    Classroom update(Classroom classroom);

    List<ClassroomLesson> getLessonsForDayOfWeek(Classroom classroom, DayOfWeek dayOfWeek);

    List<Lesson> findAllLessons();

    void addClassroomLesson(ClassroomLesson classroomLesson);

    List<List<ClassroomLesson>> getTimetable(long classroomID);

    List<StudentCountDTO> getClassWithStudentCount();

    List<TeacherHourCountDTO> getTeacherWithStudentsCount(Long TeacherId);
}
