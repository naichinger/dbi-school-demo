package at.htl.workloads.classroom;

import at.htl.workloads.room.Room;
import at.htl.workloads.student.Student;
import at.htl.workloads.teacher.Teacher;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToMany
    List<Student> students = new ArrayList<>();
    @ManyToOne
    Teacher formTeacher;
    @OneToOne
    Room classroom;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getFormTeacher() {
        return formTeacher;
    }

    public void setFormTeacher(Teacher formTeacher) {
        this.formTeacher = formTeacher;
    }
}
