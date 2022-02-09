package at.htl.workloads.teacher;

import at.htl.workloads.student.Student;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TeacherRepositoryImpl implements TeacherRepository {
    private final EntityManager entityManager;

    @Inject
    Logger LOG;

    public TeacherRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Teacher> findAll() {
        TypedQuery<Teacher> query = this.entityManager.createQuery("select t from Teacher t", Teacher.class);
        return query.getResultList();
    }

    @Override
    public Teacher findById(long id) {
        TypedQuery<Teacher> query = this.entityManager.createQuery("select t from Teacher t where t.id = :ID", Teacher.class)
                .setParameter("ID", id);
        return query.getSingleResult();
    }

    @Override
    public void add(Teacher teacher) {
        this.entityManager.persist(teacher);
    }

    @Override
    public void remove(Teacher teacher) {
        this.entityManager.remove(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return null;
    }

    @Override
    public long getMaxTeacherId() {
        long id = this.entityManager.createQuery("select max(id) from Teacher", Long.class)
                .getSingleResult();
        LOG.error(id);
        return id;
    }
}
