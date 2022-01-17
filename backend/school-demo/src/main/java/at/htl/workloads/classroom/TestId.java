package at.htl.workloads.classroom;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TestId implements Serializable {
    @ManyToOne
    ClassroomLesson classLesson;
    @ManyToOne
    Classroom classroom;

    public ClassroomLesson getClassLesson() {
        return classLesson;
    }

    public void setClassLesson(ClassroomLesson classLesson) {
        this.classLesson = classLesson;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestId testId = (TestId) o;
        return Objects.equals(classLesson, testId.classLesson) && Objects.equals(classroom, testId.classroom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classLesson, classroom);
    }
}
