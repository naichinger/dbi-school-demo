package at.htl.workloads.student;

import at.htl.IntTestBase;
import at.htl.workloads.classroom.Classroom;
import at.htl.workloads.room.Room;
import at.htl.workloads.teacher.Teacher;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
public class StudentRepositoryTest extends IntTestBase {
    @Inject
    StudentRepository studentRepository;
    @Test
    public void addStudent_getAll_simple_success() {
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
        student1.setClassroom(classroom);
        student1.setFirstname("Niklas");
        student1.setLastname("Neudorfer");
        students.add(student1);
        classroom.setStudents(students);

        assertThatCode(()->studentRepository.add(student1)).doesNotThrowAnyException();
        var loadedStudentsOfClass = studentRepository.findAllStudentsInClass(classroom.getId());
        assertThat(loadedStudentsOfClass).isNotNull().hasSize(1);
    }
}
