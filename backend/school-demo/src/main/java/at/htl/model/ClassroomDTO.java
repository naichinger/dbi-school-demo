package at.htl.model;

import at.htl.workloads.room.Room;
import at.htl.workloads.student.Student;
import at.htl.workloads.teacher.Teacher;

import java.util.ArrayList;
import java.util.List;

public class ClassroomDTO {
    String name;
    List<Long> studentIds = new ArrayList<>();
    Long teacherId;
    Long roomId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Long> studentIds) {
        this.studentIds = studentIds;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
