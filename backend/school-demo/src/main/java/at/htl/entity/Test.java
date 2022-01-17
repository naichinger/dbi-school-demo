package at.htl.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Test {
    @EmbeddedId
    TestId id;
    LocalDate date;
}
