package at.htl.workloads.teacher;

import at.htl.workloads.classroom.ClassroomService;

import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
public class TeacherServiceImpl implements TeacherService {


    private final TeacherRepository teacherRepository;

    private final ClassroomService classroomService;

    public TeacherServiceImpl(TeacherRepository teacherRepository, ClassroomService classroomService) {
        this.teacherRepository = teacherRepository;
        this.classroomService = classroomService;
    }


    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }


    @Override
    public Teacher findById(long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher addTeacher(String firstname, String lastname, BigDecimal salary) {
        Teacher teacher = Teacher.create(firstname,lastname,salary);
        teacherRepository.add(teacher);
        return teacher;
    }

    @Override
    public void removeTeacher(Teacher teacher) {
        teacherRepository.remove(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher, String firstname, String lastname, BigDecimal salary) {
        teacher.setFirstname(firstname);
        teacher.setLastname(lastname);
        teacher.setSalary(salary);
        return teacherRepository.update(teacher);
    }

    @Override
    public long getMaxTeacherId() {
        return teacherRepository.getMaxTeacherId();
    }
}
