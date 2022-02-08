package at.htl.workloads.classroom;

import at.htl.workloads.room.Room;
import at.htl.workloads.teacher.Teacher;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.api.Assertions;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;


@QuarkusTest
class ClassroomRepositoryImplTest {

    @Inject
    ClassroomRepository classroomRepository;

    @Inject
    AgroalDataSource ds;


    @Test
    @Order(10)
    void findAll() {
        Table classroom = new Table(ds, "classroom");

        List<Classroom> classrooms = classroomRepository.findAll();

        output(classroom).toConsole();
        assertThat(classrooms.size()).isEqualTo(classroom.getColumn(1).getValuesList().size());
    }

    @Test
    @Order(20)
    void findById() {
        Classroom classroomId1 = classroomRepository.findById(1);
        Classroom classroomId5 = classroomRepository.findById(5);
        Classroom classroomId12 = classroomRepository.findById(12);
        Classroom classroomId30 = classroomRepository.findById(30);

        assertThat(classroomId1.name).isEqualTo("1AFELA");
        assertThat(classroomId5.name).isEqualTo("1AHITM");
        assertThat(classroomId12.name).isEqualTo("2ABIF");
        assertThat(classroomId30.name).isEqualTo("3BHIF");
    }

    @Test
    @Order(30)
    @Transactional
    void add() {
        Table classroom = new Table(ds, "classroom");

        Classroom newClassRoom = new Classroom();

        Room room = new Room();
        room.setRoomName("Test");

        Teacher t = new Teacher();
        t.setFirstname("Test Firstname");
        t.setLastname("Test Lastname");
        t.setSalary(BigDecimal.valueOf(100));

        Lesson l = new Lesson();
        l.setName("Test Lesson");

        ClassroomLesson cl = new ClassroomLesson();
        cl.setClassroom(newClassRoom);
        cl.setDayOfWeek(DayOfWeek.MONDAY);
        cl.setStartTime(LocalTime.MIN);
        cl.setEndTime(LocalTime.MAX);
        cl.setLesson(l);

        List<ClassroomLesson> lessons = List.of(cl);

        t.setLessons(lessons);

        newClassRoom.name = "Test";
        newClassRoom.classroom = room;
        newClassRoom.formTeacher = t;
        newClassRoom.setLessons(List.of(cl));

        classroomRepository.add(newClassRoom);

        assertThat(newClassRoom.id).isEqualTo(classroom.getColumn(1).getValuesList().size());

    }

    @Test
    @Order(40)
    void remove() {
    }

    @Test
    @Order(50)
    void update() {
    }

    @Test
    @Order(60)
    void getLessonsForDayOfWeek() {
    }

    @Test
    @Order(70)
    void findAllLessons() {
    }

    @Test
    @Order(80)
    void addClassroomLesson() {
    }
}