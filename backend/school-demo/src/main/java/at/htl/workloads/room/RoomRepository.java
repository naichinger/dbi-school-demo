package at.htl.workloads.room;

import at.htl.workloads.teacher.Teacher;

import java.util.List;

public interface RoomRepository {
    List<RoomItem> findAll();

    List<Item> findAllItems();
}
