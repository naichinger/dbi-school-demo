package at.htl.workloads.classroom;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.sql.Time;

@Entity
public class ClassroomLesson {
    @EmbeddedId
    ClassroomLessonId id;
    Time start;
    Time end;
    boolean isHeld;

    public ClassroomLessonId getId() {
        return id;
    }

    public void setId(ClassroomLessonId id) {
        this.id = id;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public void setHeld(boolean held) {
        isHeld = held;
    }
}
