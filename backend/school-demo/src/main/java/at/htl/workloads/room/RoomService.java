package at.htl.workloads.room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();

    Room findById(long id);

    Room addRoom(String roomName);

    void removeRoom(Room room);

    Room updateRoom(Room room, String roomName);

    Item findItemById(long id);

    RoomItem addItem(Room room, Long itemId, int amount);

    void removeItem(Item room);

    Item updateItem(Item item, String itemName);

    long getMaxRoomId();
}
