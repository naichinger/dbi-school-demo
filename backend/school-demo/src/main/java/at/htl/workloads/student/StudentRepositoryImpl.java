package at.htl.workloads.student;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class StudentRepositoryImpl implements StudentRepository {
    EntityManager entityManager;

    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = this.entityManager.createQuery("select s from Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findById(Long studentId) {
        TypedQuery<Student> query = this.entityManager.createQuery("select s from Student s where s.id=:ID", Student.class);
        query.setParameter("ID", studentId);
        return query.getSingleResult();
    }

    @Override
    public Student update(Student student) {
        return entityManager.merge(student);
    }
}
