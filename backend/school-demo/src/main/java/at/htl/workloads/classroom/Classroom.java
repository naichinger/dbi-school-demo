package at.htl.workloads.classroom;

import at.htl.workloads.room.Room;
import at.htl.workloads.student.Student;
import at.htl.workloads.teacher.Teacher;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToMany(mappedBy = "classroom", cascade = CascadeType.PERSIST)
    List<Student> students = new ArrayList<>();
    @OneToMany(mappedBy = "classroom", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<ClassroomLesson> lessons = new ArrayList<>();
    @OneToMany
    List<Test> tests = new ArrayList<>();
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Teacher formTeacher;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Room classroom;

    public static Classroom create(
            String name,
            Teacher teacher,
            Room room,
            List<Student> students) {
        Classroom classroom = new Classroom();
        classroom.setName(name);
        classroom.setFormTeacher(teacher);
        classroom.setClassroom(room);
        classroom.setStudents(students);
        return classroom;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

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

    public Room getClassroom() {
        return classroom;
    }

    public void setClassroom(Room classroom) {
        this.classroom = classroom;
    }

    public List<ClassroomLesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<ClassroomLesson> lessons) {
        this.lessons = lessons;
    }
}
