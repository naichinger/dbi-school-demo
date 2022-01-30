package at.htl.workloads.department;

import at.htl.workloads.classroom.Classroom;
import org.hibernate.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class DepartmentRepositoryImpl implements DepartmentRepository {
    private final EntityManager entityManager;

    public DepartmentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Department findById(long id) {
        TypedQuery<Department> typedQuery =
                this.entityManager.createQuery("select d from Department d where d.id = :ID", Department.class);
        typedQuery.setParameter("ID", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public DepartmentExecutive findExecutiveById(long headOfDepartmentId) {
        TypedQuery<DepartmentExecutive> typedQuery =
                this.entityManager.createQuery("select de from DepartmentExecutive de where de.id = :ID", DepartmentExecutive.class);
        typedQuery.setParameter("ID", headOfDepartmentId);
        return typedQuery.getSingleResult();
    }

    @Override
    @Transactional
    public Department add(Department department) {
        entityManager.persist(department);
        return department;
    }

    @Override
    public void remove(Department department) {
        entityManager.remove(department);
    }

    @Override
    @Transactional
    public Department update(Department department) {
        return entityManager.merge(department);
    }

    @Override
    public DepartmentExecutive addExecutive(DepartmentExecutive executive) {
        entityManager.persist(executive);
        return executive;
    }

    @Override
    public void removeExecutive(DepartmentExecutive departmentExecutive) {
        entityManager.remove(departmentExecutive);
    }

    @Override
    public DepartmentExecutive updateExecutive(DepartmentExecutive executive) {
        return entityManager.merge(executive);
    }
}
