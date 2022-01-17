package at.htl.workloads.classroom;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class ClassroomRepositoryImpl implements ClassroomRepository {

    private final EntityManager entityManager;

    public ClassroomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Classroom> findAll() {
        TypedQuery<Classroom> typedQuery =
                this.entityManager.createQuery("select c from Classroom c", Classroom.class);
        return typedQuery.getResultList();
    }

    @Override
    public Classroom findById(long id) {
        TypedQuery<Classroom> typedQuery =
                this.entityManager.createQuery("select c from Classroom c where c.id = :ID", Classroom.class);
        typedQuery.setParameter("ID", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void add(Classroom classroom) {
        this.entityManager.persist(classroom);
    }

    @Override
    public void remove(Classroom classroom) {
        this.entityManager.remove(classroom);
    }

    @Override
    public Classroom update(Classroom classroom) {
        return this.entityManager.merge(classroom);
    }
}
