package at.htl.workloads.room;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class  RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findById(long id) {
        return roomRepository.findById(id);
    }

    @Override
    public Room addRoom(String roomName) {
        return roomRepository.addRoom(Room.create(roomName));
    }

    @Override
    public void removeRoom(Room room) {
        roomRepository.removeRoom(room);
    }

    @Override
    public Room updateRoom(Room room, String roomName) {
        room.setRoomName(roomName);
        return roomRepository.updateRoom(room);
    }

    @Override
    public Item findItemById(long id) {
        return roomRepository.findByItemId(id);
    }

    @Override
    public RoomItem addItem(Room room, Long itemId, int amount) {
        Item item = findItemById(itemId);
        RoomItemId roomItemId = new RoomItemId();
        roomItemId.setRoom(room);
        roomItemId.setItem(item);

        RoomItem newItem = new RoomItem();
        newItem.setId(roomItemId);
        newItem.setAmount(amount);
        return newItem;
    }

    @Override
    public void removeItem(Item item) {
        roomRepository.removeItem(item);
    }

    @Override
    public Item updateItem(Item item, String itemName) {
        item.setName(itemName);
        return item;
    }

    @Override
    public long getMaxRoomId() {
        return roomRepository.getMaxRoomId();
    }
}
