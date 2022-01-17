package at.htl.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RoomItemId implements Serializable {
    @ManyToOne
    Room room;
    @ManyToOne
    Item item;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomItemId that = (RoomItemId) o;
        return Objects.equals(room, that.room) && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, item);
    }
}
