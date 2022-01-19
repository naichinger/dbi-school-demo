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
    String firstname;
    String lastname;
    BigDecimal salary;
    boolean isFree;
    @OneToMany(mappedBy = "teacher")
    List<ClassroomLesson> lessons = new ArrayList<>();

    public boolean isFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    public List<ClassroomLesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<ClassroomLesson> lessons) {
        this.lessons = lessons;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
