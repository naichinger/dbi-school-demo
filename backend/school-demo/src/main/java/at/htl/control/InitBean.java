package at.htl.control;

import at.htl.workloads.classroom.Classroom;
import at.htl.workloads.classroom.ClassroomLesson;
import at.htl.workloads.classroom.ClassroomService;
import at.htl.workloads.classroom.Lesson;
import at.htl.workloads.room.Room;
import at.htl.workloads.room.RoomService;
import at.htl.workloads.student.Student;
import at.htl.workloads.student.StudentService;
import at.htl.workloads.teacher.Teacher;
import at.htl.workloads.teacher.TeacherService;
import io.quarkus.logging.Log;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class InitBean {

    @Inject
    StudentService studentService;
    @Inject
    ClassroomService classroomService;
    @Inject
    TeacherService teacherService;
    @Inject
    RoomService roomService;

    @Transactional
    public void init(@Observes StartupEvent event) {
        //TODO: add algorithm to add sample data with existing data from import.sql
        addStudentsToClasses();
        addLessonsToClasses();
    }

    private void addStudentsToClasses() {
        List<Student> allStudents = studentService.findAll();
        List<Classroom> allClassrooms = classroomService.findAll();
        for (int i = 0; i < allStudents.size(); i++) {
            allStudents.get(i).setClassroom(allClassrooms.get(i % allClassrooms.size()));
            studentService.update(allStudents.get(i));
        }
    }

    private void addLessonsToClasses() {
        List<Classroom> allClassrooms = classroomService.findAll();
        List<Teacher> allTeachers = teacherService.findAll();
        List<Lesson> allLessons = classroomService.findAllLessons();

        long maxTeacherId = teacherService.getMaxTeacherId();
        long maxRoomId = roomService.getMaxRoomId();

        for (Classroom classroom : allClassrooms) {

            Random rand = new Random();

            classroom.setFormTeacher(
                    teacherService.findById(rand.nextInt(
                            Math.toIntExact(maxTeacherId-1))+1
            ));

            classroom.setClassroom(roomService.findById(
                    rand.nextInt(Math.toIntExact(maxRoomId-1))+1
            ));


            for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
                if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {

                    Random random = new Random();

                    List<LocalTime[]> lessonTimes = new LinkedList<>();
                    LocalTime current = LocalTime.of(8, 0);

                    for (int i = 0; i < 8; i++) {
                        int minute = current.getMinute() + 50;
                        int hour = current.getHour() + (minute >= 60 ? 1 : 0);
                        minute = minute % 60;

                        LocalTime start = LocalTime.of(current.getHour(), current.getMinute());
                        LocalTime end = LocalTime.of(hour, minute);

                        lessonTimes.add(new LocalTime[]{start, end});

                        minute = minute + 5;
                        hour = hour + (minute >= 60 ? 1 : 0);
                        minute = minute % 60;

                        current = LocalTime.of(hour, minute);
                    }

                    for (LocalTime[] lessonTime : lessonTimes) {
                        ClassroomLesson classroomLesson = new ClassroomLesson();

                        classroomLesson.setClassroom(classroom);
                        classroomLesson.setLesson(allLessons.get(random.nextInt(allLessons.size())));
                        classroomLesson.setDayOfWeek(dayOfWeek);
                        classroomLesson.setStartTime(lessonTime[0]);
                        classroomLesson.setEndTime(lessonTime[1]);
                        Teacher teacher = allTeachers.get(random.nextInt(allTeachers.size())); //getFreeTeacher();
                        classroomLesson.setTeacher(teacher);
                        //teacher.setIsFree(false);
                        classroomService.addClassroomLesson(classroomLesson);
                        //classroomLesson.set
                    }
                    //setAllTeacherFree();
                }
            }
        }
    }

//    private void setAllTeacherFree(){
//        List<Teacher> allTeachers = teacherService.findAll();
//        if (allTeachers == null)
//            return;
//        for (Teacher t: allTeachers) {
//            t.setIsFree(true);
//        }
//    }

//    private Teacher getFreeTeacher(){
//        Random random = new Random();
//        List<Teacher> allTeachers = teacherService.findAll();
//        int tempTeacherId = random.nextInt(allTeachers.size());
//        Teacher teacher = allTeachers.get(tempTeacherId);
//        if (!teacher.isFree()){
//            return getFreeTeacher();
//        }
//        return teacher;
//    }
}
