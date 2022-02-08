package at.htl.workloads.teacher;

import at.htl.workloads.student.Student;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class TeacherServiceImplTest {

    @Inject
    TeacherService teacherService;

    @Inject
    AgroalDataSource ds;

    @Test
    void findAll() {

        Table teacher = new Table(ds, "teacher");

        List<Teacher> t = teacherService.findAll();

        assertThat(t.size()).isEqualTo(teacher.getColumn(0).getValuesList().size());

    }

    @Test
    void findById() {

        Table teacher = new Table(ds, "teacher");

        Teacher t = teacherService.findById((long) teacher.getColumn(1).getValuesList().size());

        assertThat(t.id).isEqualTo(teacher.getColumn(1).getValuesList().size());


    }

    @Test
    @Transactional
    void addTeacher() {

        Table teacher = new Table(ds, "teacher");

        int count  = teacher.getColumn(0).getValuesList().size();

        teacherService.addTeacher("New", "TestTeacher", new BigDecimal(9323));

        teacher = new Table(ds, "teacher");

        assertThat(count + 1).isEqualTo(teacher.getColumn(0).getValuesList().size());

    }

    @Test
    void updateTeacher() {

        Teacher t = teacherService.findById(10);

        teacherService.updateTeacher(t, "Test", t.lastname, t.salary);

        assertThat(t.firstname).isEqualTo("Test");


    }
}