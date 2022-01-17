package at.htl.workloads.teacher;

import at.htl.workloads.classroom.ClassroomLesson;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    BigDecimal salary;
    @OneToMany(mappedBy = "teacher")
    List<ClassroomLesson> lessons = new ArrayList<>();

    public List<ClassroomLesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<ClassroomLesson> lessons) {
        this.lessons = lessons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
