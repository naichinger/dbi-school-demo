package at.htl.workloads.room;


import at.htl.workloads.classroom.Classroom;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RoomRepositoryImpl implements RoomRepository {

    @Inject
    EntityManager entityManager;
    @Inject
    Logger LOG;

    @Override
    public List<Room> findAll() {
        TypedQuery<Room> typedQuery =
                this.entityManager.createQuery("select r from Room r", Room.class);
        return typedQuery.getResultList();
    }

    @Override
    public Room findById(long id) {
        TypedQuery<Room> typedQuery =
                this.entityManager.createQuery("select r from Room r where r.id=:ID", Room.class);
        typedQuery.setParameter("ID", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public Room addRoom(Room newRoom) {
        entityManager.persist(newRoom);
        return newRoom;
    }

    @Override
    public void removeRoom(Room room) {
        entityManager.remove(room);
    }

    @Override
    public Room updateRoom(Room room) {
        return entityManager.merge(room);
    }

    @Override
    public Item findByItemId(long id) {
        TypedQuery<Item> typedQuery =
                this.entityManager.createQuery("select i from Item i where i.id=:ID", Item.class);
        typedQuery.setParameter("ID", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void removeItem(Item item) {
        entityManager.remove(item);
    }

    @Override
    public long getMaxRoomId() {
        long id = this.entityManager.createQuery("select max(id) from Room", Long.class)
                .getSingleResult();
        LOG.error(id);
        return id;
    }
}
