package at.htl.workloads.classroom;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    ClassroomLesson lesson;
    LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ClassroomLesson getLesson() {
        return lesson;
    }

    public void setLesson(ClassroomLesson lesson) {
        this.lesson = lesson;
    }
}
