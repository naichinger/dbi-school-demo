package at.htl.workloads.room;


import at.htl.workloads.teacher.Teacher;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class RoomRepositoryImpl implements RoomRepository {
    private final EntityManager entityManager;
    public RoomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<RoomItem> findAll() {
        TypedQuery<RoomItem> query = this.entityManager.createQuery("select r from Room r", RoomItem.class);
        return query.getResultList();
    }

    @Override
    public List<Item> findAllItems() {
        TypedQuery<Item> query = this.entityManager.createQuery("select i from Item i", Item.class);
        return query.getResultList();
    }
}
