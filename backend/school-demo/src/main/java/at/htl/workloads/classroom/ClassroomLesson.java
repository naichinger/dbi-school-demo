package at.htl.workloads.classroom;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalTime;

@Entity
public class ClassroomLesson {
    @EmbeddedId
    ClassroomLessonId id;
    LocalTime start;
    LocalTime end;
    boolean isHeld;

    public ClassroomLessonId getId() {
        return id;
    }

    public void setId(ClassroomLessonId id) {
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
