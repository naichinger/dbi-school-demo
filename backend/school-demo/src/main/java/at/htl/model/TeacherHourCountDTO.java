package at.htl.model;

import at.htl.workloads.teacher.Teacher;

public class TeacherHourCountDTO {

    public String t;

    public Long studentCount;

    public TeacherHourCountDTO(String t, Long studentCount) {
        this.t = t;
        this.studentCount = studentCount;
    }

}
