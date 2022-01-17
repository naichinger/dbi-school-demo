package at.htl.workloads.room;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class RoomItem {
    @EmbeddedId
    RoomItemId id;

    public RoomItemId getId() {
        return id;
    }

    public void setId(RoomItemId id) {
        this.id = id;
    }
}
