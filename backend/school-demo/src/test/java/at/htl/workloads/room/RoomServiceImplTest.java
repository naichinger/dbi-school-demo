package at.htl.workloads.room;

import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class RoomServiceImplTest {

    @Inject
    RoomService roomService;

    @Inject
    RoomRepository roomRepository;

    @Inject
    AgroalDataSource ds;

    @Test
    void findAll() {

        Table room = new Table(ds, "room");

        List<Room> rooms = roomService.findAll();

        assertThat(rooms.size()).isEqualTo(room.getColumn(0).getValuesList().size());
    }

    @Test
    void findById() {

        Room r = roomService.findById(10);

        assertThat(r.roomName).isEqualTo("120");

    }

    @Test
    @Transactional
    void addRoom() {

        Table room = new Table(ds, "room");

        int count = room.getColumn(0).getValuesList().size();

        this.add("Test");

        room = new Table(ds, "room");

        assertThat(count+1).isEqualTo(room.getColumn(0).getValuesList().size());


    }


    private void add(String name){
        roomService.addRoom(name);
    }

}