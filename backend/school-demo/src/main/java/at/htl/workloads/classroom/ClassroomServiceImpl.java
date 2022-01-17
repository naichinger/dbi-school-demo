package at.htl.workloads.classroom;

import at.htl.model.ClassroomDTO;
import at.htl.workloads.room.Room;
import at.htl.workloads.student.Student;
import at.htl.workloads.teacher.Teacher;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class ClassroomServiceImpl implements ClassroomService {

    @Inject
    ClassroomRepository classroomRepository;

    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom findById(long id) {
        return classroomRepository.findById(id);
    }

    @Override
    public Classroom addClassroom(String name, Long teacherId, Long roomId, List<Long> studentIds) {
        //TODO: use other services to get entities
        Teacher teacher = null;
        Room room = null;
        List<Student> students = null;
        Classroom classroom = Classroom.create(name, teacher, room, students);
        classroomRepository.add(classroom);
        return classroom;
    }

    @Override
    public void removeClassroom(Classroom classroom) {
        classroomRepository.remove(classroom);
    }

    @Override
    public Classroom updateClassroom(long id, String name, Long teacherId, Long roomId, List<Long> studentIds) {
        //TODO: use other services to get entities
        Classroom classroom = this.classroomRepository.findById(id);
        classroom.setName(name);
        Teacher teacher = null;
        Room room = null;
        List<Student> students = null;
        return this.classroomRepository.update(classroom);
    }
}
