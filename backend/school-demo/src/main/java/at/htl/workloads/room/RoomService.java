package at.htl.workloads.room;

import java.util.List;

public interface RoomService {
    List<Item> findAllItems();

    List<RoomItem> findAll();
}
