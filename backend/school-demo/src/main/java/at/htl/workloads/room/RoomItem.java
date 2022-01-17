package at.htl.workloads.room;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class RoomItem {
    @EmbeddedId
    RoomItemId id;
    int amount;

    public RoomItemId getId() {
        return id;
    }

    public void setId(RoomItemId id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
