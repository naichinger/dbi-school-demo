package at.htl.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.sql.Time;
import java.time.LocalTime;

@Entity
public class ClassLesson {
    @EmbeddedId
    ClassLessonId id;
    LocalTime start;
    LocalTime end;
    boolean isHeld;

    public ClassLessonId getId() {
        return id;
    }

    public void setId(ClassLessonId id) {
        this.id = id;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public void setHeld(boolean held) {
        isHeld = held;
    }
}
