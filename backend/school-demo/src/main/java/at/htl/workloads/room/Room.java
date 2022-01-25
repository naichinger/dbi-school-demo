package at.htl.workloads.room;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String roomName;
    @OneToMany(mappedBy = "id.room")
    List<RoomItem> items = new ArrayList<>();

    public static Room create(String roomName) {
        Room room = new Room();
        room.setRoomName(roomName);
        return room;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
