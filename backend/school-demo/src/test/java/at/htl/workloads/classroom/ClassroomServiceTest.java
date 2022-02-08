package at.htl.workloads.classroom;

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
class ClassroomServiceTest {

    @Inject
    ClassroomService service;

    @Inject
    AgroalDataSource ds;

    @Test
    void findAll() {
        List<Classroom> res = service.findAll();

        Table classroom = new Table(ds, "classroom");

        assertThat(res.size()).isEqualTo(classroom.getColumn(1).getValuesList().size());

    }

    @Test
    void findById() {
        Table classroom = new Table(ds, "classroom");

        Classroom c = service.findById(classroom.getColumn(1).getValuesList().size());

        assertThat(c.id).isEqualTo(classroom.getColumn(1).getValuesList().size());

    }

    @Test
    void addClassroom() {

        Table classroom = new Table(ds, "classroom");

        Classroom c = service.findById(Long.valueOf(classroom.getColumn(1).getValuesList().size()));

        add();

        assertThat(Long.valueOf(classroom.getColumn(1).getValuesList().size())).isEqualTo(c.id);

    }

    @Transactional
    void add(){
        List<Long> sids = List.of(1L,2L,3L, 4L, 5L);
        service.addClassroom("Test", 10L, 3L, sids);
    }

//    @Test
//    @Transactional
//    void removeClassroom() {
//        Table classroom = new Table(ds, "classroom");
//
//        Classroom c = service.findById(Long.valueOf(classroom.getColumn(1).getValuesList().size()));
//
//        service.removeClassroom(c);
//
//        classroom = new Table(ds, "classroom");
//
//        assertThat(c.id).isEqualTo(classroom.getColumn(1).getValuesList().size());
//    }
//
//    @Test
//    @Transactional
//    void updateClassroom() {
//        Table classroom = new Table(ds, "classroom");
//
//        Classroom c = service.findById(Long.valueOf(classroom.getColumn(1).getValuesList().size()));
//
//        c.setName("UpdateTest");
//
//        service.updateClassroom(c);
//
//        Classroom i = service.findById(c.id);
//
//        assertThat(c.name).isEqualTo(i.name);
//
//    }

}