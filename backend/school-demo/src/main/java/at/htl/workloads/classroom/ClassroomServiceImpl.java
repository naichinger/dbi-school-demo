package at.htl.workloads.classroom;

import at.htl.model.TeacherHourCountDTO;
import at.htl.workloads.room.Room;
import at.htl.workloads.room.RoomService;
import at.htl.workloads.student.Student;
import at.htl.workloads.student.StudentService;
import at.htl.workloads.teacher.Teacher;
import at.htl.workloads.teacher.TeacherService;

import javax.enterprise.context.ApplicationScoped;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final RoomService roomService;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository, StudentService studentService, TeacherService teacherService, RoomService roomService) {
        this.classroomRepository = classroomRepository;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.roomService = roomService;
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
    public Classroom addClassroom(String name, Long teacherId, Long roomId, List<Long> studentIds) {
        //TODO: use other services to get entities
        Teacher teacher = teacherService.findById(teacherId);
        Room room = roomService.findById(roomId);
        List<Student> students = studentService.findByIds(studentIds);
        Classroom classroom = Classroom.create(name, teacher, room, students);
        classroomRepository.add(classroom);
        return classroom;
    }

    @Override
    public void removeClassroom(Classroom classroom) {
        classroomRepository.remove(classroom);
    }

    @Override
    public Classroom updateClassroom(Classroom classroom, String name, Long teacherId, Long roomId, List<Long> studentIds) {
        //TODO: use other services to get entities
        Teacher teacher = teacherService.findById(teacherId);
        Room room = roomService.findById(roomId);
        List<Student> students = studentService.findByIds(studentIds);

        classroom.setName(name);
        classroom.setFormTeacher(teacher);
        classroom.setClassroom(room);
        classroom.setStudents(students);

        return this.classroomRepository.update(classroom);
    }

    @Override
    public Classroom updateClassroom(Classroom classroom) {
        return this.classroomRepository.update(classroom);
    }

    @Override
    public List<ClassroomLesson> getLessonsForDayOfWeek(Classroom classroom, DayOfWeek dayOfWeek) {
        return classroomRepository.getLessonsForDayOfWeek(classroom, dayOfWeek);
    }

    @Override
    public List<Lesson> findAllLessons() {
        return classroomRepository.findAllLessons();
    }

    @Override
    public void addClassroomLesson(ClassroomLesson classroomLesson) {
        classroomRepository.addClassroomLesson(classroomLesson);
    }

    @Override
    public List<TeacherHourCountDTO> getTeacherWithStudentsCount(Long TeacherId) {
        return classroomRepository.getTeacherWithStudentsCount(TeacherId);
    }
}
