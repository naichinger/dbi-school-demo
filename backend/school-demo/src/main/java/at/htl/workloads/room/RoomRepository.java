package at.htl.workloads.room;

import java.util.List;

public interface RoomRepository {
    List<Room> findAll();

    Room findById(long id);

    Room addRoom(Room newRoom);

    void removeRoom(Room room);

    Room updateRoom(Room room);

    Item findByItemId(long id);

    void removeItem(Item item);

    long getMaxRoomId();
}
