package at.htl.model;

import at.htl.workloads.classroom.Classroom;

public class StudentCountDTO {

    public Classroom c;

    public Long StudentCound;

    public StudentCountDTO(Classroom c, Long studentCound) {
        this.c = c;
        StudentCound = studentCound;
    }
}
