package at.htl.workloads.classroom;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.sql.Time;

@Entity
public class ClassroomLesson {
    @EmbeddedId
    ClassroomLessonId id;
    boolean isHeld;

    public ClassroomLessonId getId() {
        return id;
    }

    public void setId(ClassroomLessonId id) {
        this.id = id;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public void setHeld(boolean held) {
        isHeld = held;
    }
}
