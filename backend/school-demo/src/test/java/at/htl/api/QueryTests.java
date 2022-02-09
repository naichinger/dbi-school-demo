package at.htl.api;

import at.htl.model.StudentCountDTO;
import at.htl.model.TeacherHourCountDTO;
import at.htl.workloads.classroom.ClassroomRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@QuarkusTest
public class QueryTests {

    // a map key class value anzahl der schüler in dieser klasse
    // teacher und die anzahler aller schüler


    @Inject
    ClassroomRepository classroomRepository;

    @Test
    void classAndStudentCount() {
        List<StudentCountDTO> map = classroomRepository.getClassWithStudentCount();

    }

    @Test
    void teacherAndStudentCount() {
        List<TeacherHourCountDTO> map = classroomRepository.getTeacherWithStudentsCount(12L);

    }

}
