package at.htl.model;

import at.htl.workloads.teacher.Teacher;

public class TeacherHourCountDTO {

    public String t;

    public Long studentCount;

    public TeacherHourCountDTO(String t, Long studentCount) {
        this.t = t;
        this.studentCount = studentCount;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public Long getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Long studentCount) {
        this.studentCount = studentCount;
    }

    @Override
    public String toString() {
        return String.format("%s %s",
                t,
                studentCount.toString());
    }
}
