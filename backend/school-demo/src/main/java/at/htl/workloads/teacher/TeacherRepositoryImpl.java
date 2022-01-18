package at.htl.workloads.teacher;

import at.htl.workloads.student.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class TeacherRepositoryImpl implements TeacherRepository {
    private final EntityManager entityManager;

    public TeacherRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Teacher> findAll() {
        TypedQuery<Teacher> query = this.entityManager.createQuery("select t from Teacher t", Teacher.class);
        return query.getResultList();
    }
}
