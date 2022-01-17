package at.htl.workloads.classroom;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Test {
    @EmbeddedId
    TestId id;
    LocalDate date;

    public TestId getId() {
        return id;
    }

    public void setId(TestId id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
