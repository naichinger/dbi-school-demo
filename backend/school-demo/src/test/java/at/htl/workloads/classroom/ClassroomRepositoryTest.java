package at.htl.workloads.classroom;

import at.htl.IntTestBase;
import at.htl.workloads.room.Room;
import at.htl.workloads.student.Student;
import at.htl.workloads.teacher.Teacher;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
public class ClassroomRepositoryTest extends IntTestBase {
    @Inject
    ClassroomRepository classroomRepository;

    @Test
    public void addClassroom_with_classroomLessons_and_get_simple_success() {
        Teacher teacher = new Teacher();
        teacher.setFirstname("Anna");
        teacher.setLastname("Wiesinger");
        teacher.setSalary(BigDecimal.valueOf(2100));
        Room room = new Room();
        room.setRoomName("3EHIF");
        Classroom classroom = new Classroom();
        classroom.setClassroom(room);
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        Student student2 = new Student();
        student1.setClassroom(classroom);
        student1.setFirstname("Niklas");
        student1.setLastname("Neudorfer");
        student2.setClassroom(classroom);
        student1.setFirstname("Rapael");
        student1.setLastname("Ablinger");
        students.add(student1);
        students.add(student2);
        classroom.setStudents(students);

        Lesson lesson1 = new Lesson();
        lesson1.setName("English");
        Lesson lesson2 = new Lesson();
        lesson2.setName("Mathematik");
        Lesson lesson3 = new Lesson();
        lesson3.setName("Religion");

        List<ClassroomLesson> classroomLessons = new ArrayList<>();
        ClassroomLesson classroomLesson = new ClassroomLesson();
        classroomLesson.setClassroom(classroom);
        classroomLesson.setLesson(lesson1);
        classroomLesson.setDayOfWeek(DayOfWeek.MONDAY);
        classroomLesson.setStartTime(LocalTime.of(8, 00, 00, 11001));
        classroomLesson.setStartTime(LocalTime.of(8, 50, 00, 11001));

        ClassroomLesson classroomLesson2 = new ClassroomLesson();
        classroomLesson2.setClassroom(classroom);
        classroomLesson2.setLesson(lesson2);
        classroomLesson2.setDayOfWeek(DayOfWeek.MONDAY);
        classroomLesson2.setStartTime(LocalTime.of(8, 55, 00, 11001));
        classroomLesson2.setStartTime(LocalTime.of(9, 45, 00, 11001));

        classroomLessons.add(classroomLesson);
        classroomLessons.add(classroomLesson2);
        classroom.setLessons(classroomLessons);

        assertThatCode(()->classroomRepository.add(classroom)).doesNotThrowAnyException();

        ClassroomLesson classroomLesson3 = new ClassroomLesson();
        classroomLesson3.setClassroom(classroom);
        classroomLesson3.setLesson(lesson3);
        classroomLesson3.setDayOfWeek(DayOfWeek.MONDAY);
        classroomLesson3.setStartTime(LocalTime.of(10, 00, 00, 11001));
        classroomLesson3.setStartTime(LocalTime.of(10, 50, 00, 11001));

        assertThatCode(()->classroomRepository.addClassroomLesson(classroomLesson3)).doesNotThrowAnyException();
        var loadedClassroom  = classroomRepository.findById(classroom.id);
        assertThat(loadedClassroom).isNotNull().isEqualTo(classroom);
        var loadedClassRoomLessons = classroomRepository.findAllLessons();
        assertThat(loadedClassRoomLessons).isNotNull();
    }
}
