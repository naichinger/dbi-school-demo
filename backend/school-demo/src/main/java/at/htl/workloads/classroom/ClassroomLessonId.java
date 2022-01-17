package at.htl.workloads.classroom;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClassroomLessonId implements Serializable {
    @ManyToOne
    Classroom classroom;
    @ManyToOne
    Lesson lesson;

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassroomLessonId that = (ClassroomLessonId) o;
        return Objects.equals(classroom, that.classroom) && Objects.equals(lesson, that.lesson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classroom, lesson);
    }
}
