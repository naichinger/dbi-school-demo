package at.htl.workloads.classroom;

import at.htl.model.ClassroomDTO;
import at.htl.workloads.room.Room;
import at.htl.workloads.student.Student;
import at.htl.workloads.teacher.Teacher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom findById(long id) {
        return classroomRepository.findById(id);
    }

    @Override
    public Classroom addClassroom(String name, Long teacherId, Long roomId, List<Long> studentIds, List<Long> lessonIds, List<Long> testIds) {
        //TODO: use other services to get entities
        Teacher teacher = null;
        Room room = null;
        List<Student> students = new ArrayList<>();
        List<ClassroomLesson> lessons = new ArrayList<>();
        List<Test> tests = new ArrayList<>();
        Classroom classroom = Classroom.create(name, teacher, room, students, lessons, tests);
        classroomRepository.add(classroom);
        return classroom;
    }

    @Override
    public void removeClassroom(Classroom classroom) {
        classroomRepository.remove(classroom);
    }

    @Override
    public Classroom updateClassroom(Classroom classroom, String name, Long teacherId, Long roomId, List<Long> studentIds, List<Long> lessonIds, List<Long> testIds) {
        //TODO: use other services to get entities
        Teacher teacher = null;
        Room room = null;
        List<Student> students = new ArrayList<>();
        List<ClassroomLesson> lessons = new ArrayList<>();
        List<Test> tests = new ArrayList<>();

        classroom.setName(name);
        classroom.setFormTeacher(teacher);
        classroom.setClassroom(room);
        classroom.setStudents(students);
        classroom.setLessons(lessons);
        classroom.setTests(tests);

        return this.classroomRepository.update(classroom);
    }

    @Override
    public List<ClassroomLesson> getLessonsForDayOfWeek(Classroom classroom, DayOfWeek dayOfWeek) {
        return classroomRepository.getLessonsForDayOfWeek(classroom, dayOfWeek);
    }
}
