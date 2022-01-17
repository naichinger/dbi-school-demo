package at.htl.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TestId implements Serializable {
    @ManyToOne
    ClassLesson classLesson;
    @ManyToOne
    Class classroom;

    public ClassLesson getClassLesson() {
        return classLesson;
    }

    public void setClassLesson(ClassLesson classLesson) {
        this.classLesson = classLesson;
    }

    public Class getClassroom() {
        return classroom;
    }

    public void setClassroom(Class classroom) {
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
