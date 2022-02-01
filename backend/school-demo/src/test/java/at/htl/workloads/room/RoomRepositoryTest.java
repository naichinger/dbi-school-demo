package at.htl.workloads.room;

import at.htl.IntTestBase;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
public class RoomRepositoryTest extends IntTestBase {
    @Inject
    RoomRepository roomRepository;

    @Test
    public void remove_Items_simple_success() {
        Item i1 = new Item();
        i1.setName("Tisch");
        Item i2 = new Item();
        i1.setName("Sessel");
        Item i3 = new Item();
        i1.setName("SmartBoard");
        Item i4 = new Item();
        i1.setName("Beamer");
        Room room = new Room();
        room.setRoomName("4EHIF");

        RoomItemId riId = new RoomItemId();
        riId.setRoom(room);
        riId.setItem(i1);
        RoomItem ri = new RoomItem();
        ri.setId(riId);
        ri.setAmount(13);

        RoomItemId riId2 = new RoomItemId();
        riId2.setRoom(room);
        riId2.setItem(i2);
        RoomItem ri2 = new RoomItem();
        ri2.setId(riId2);
        ri2.setAmount(25);

        RoomItemId riId3 = new RoomItemId();
        riId3.setRoom(room);
        riId3.setItem(i3);
        RoomItem ri3 = new RoomItem();
        ri3.setId(riId3);
        ri3.setAmount(1);

        RoomItemId riId4 = new RoomItemId();
        riId4.setRoom(room);
        riId4.setItem(i1);
        RoomItem ri4 = new RoomItem();
        ri4.setId(riId4);
        ri4.setAmount(1);

        assertThatCode(()->roomRepository.addRoom(room)).doesNotThrowAnyException();
        var loadedRoom = roomRepository.findById(room.id);
        assertThat(loadedRoom.items).isNotNull().hasSize(4);

        assertThatCode(()->roomRepository.removeItem(i4)).doesNotThrowAnyException();
        var loadedRoomWithOutRemovedItem = roomRepository.findById(room.id);
        assertThat(loadedRoomWithOutRemovedItem.items).isNotNull().hasSize(3);
    }
}
