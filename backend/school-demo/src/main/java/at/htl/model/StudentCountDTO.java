package at.htl.model;

import at.htl.workloads.classroom.Classroom;

public class StudentCountDTO {

    public Classroom c;

    public Long StudentCound;

    public StudentCountDTO(Classroom c, Long studentCound) {
        this.c = c;
        StudentCound = studentCound;
    }

    public Classroom getC() {
        return c;
    }

    public void setC(Classroom c) {
        this.c = c;
    }

    public Long getStudentCound() {
        return StudentCound;
    }

    public void setStudentCound(Long studentCound) {
        StudentCound = studentCound;
    }

    @Override
    public String toString() {
        return String.format("%s %s",
                c.getName(),
                getStudentCound().toString()
                );
    }
}
