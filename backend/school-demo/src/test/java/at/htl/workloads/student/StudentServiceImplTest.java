package at.htl.workloads.student;

import at.htl.workloads.classroom.Classroom;
import at.htl.workloads.room.Room;
import at.htl.workloads.room.RoomService;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class StudentServiceImplTest {


    @Inject
    AgroalDataSource ds;

    @Inject
    StudentServiceImpl studentService;


    @Test
    void findAll() {

        Table student = new Table(ds, "student");

        List<Student> s = studentService.findAll();

        assertThat(s.size()).isEqualTo(student.getColumn(0).getValuesList().size());
    }

    @Test
    void findById() {
        Table student = new Table(ds, "student");

        Student s = studentService.findById((long) student.getColumn(1).getValuesList().size());

        assertThat(s.id).isEqualTo(student.getColumn(1).getValuesList().size());

    }

    @Test
    void findByIds() {
        Table student = new Table(ds, "student");

        Long l = Long.valueOf(student.getColumn(0).getValuesList().size());

        List<Long> ids = List.of(l, l - 1, l - 2);

        List<Student> s = studentService.findByIds(ids);

        assertThat(s.size()).isEqualTo(3);
    }

    @Test
    @Transactional
    void update() {

        Student s = studentService.findById(10L);

        s.setFirstname("TestName");

        studentService.update(s);

        Student p = studentService.findById(10L);

        assertThat(p.firstname).isEqualTo("TestName");
    }
}