package at.htl.workloads.room;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    @Override
    public List<Item> findAllItems() {
        return roomRepository.findAllItems();
    }

    @Override
    public List<RoomItem> findAll() {
        return roomRepository.findAll();
    }

}
