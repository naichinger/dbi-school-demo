package at.htl.workloads.teacher;

import at.htl.workloads.classroom.Classroom;
import at.htl.workloads.classroom.ClassroomLesson;
import at.htl.workloads.classroom.Lesson;
import at.htl.workloads.room.Room;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
public class TeacherRepositoryTest {
    @Inject
    TeacherRepository teacherRepository;
    @Test
    public void updateTeacher_getById_simple_success() {
        Teacher teacher = new Teacher();
        Room room = new Room();
        room.setRoomName("3EHIF");
        Classroom classroom = new Classroom();
        classroom.setClassroom(room);

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
        teacher.setLessons(classroomLessons);

        teacher.setSalary(BigDecimal.valueOf(3800));
        teacher.setFirstname("Niklas");
        teacher.setLastname("Aichinger");

        assertThatCode(()->teacherRepository.add(teacher)).doesNotThrowAnyException();
        var loadedTeacher = teacherRepository.findById(teacher.id);

        assertThat(loadedTeacher.id).isNotNull().isEqualTo(teacher.id);
    }
}
