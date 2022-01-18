package at.htl.workloads.teacher;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
