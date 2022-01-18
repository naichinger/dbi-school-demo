package at.htl.control;

import at.htl.workloads.classroom.Classroom;
import at.htl.workloads.classroom.ClassroomLesson;
import at.htl.workloads.classroom.ClassroomService;
import at.htl.workloads.classroom.Lesson;
import at.htl.workloads.student.Student;
import at.htl.workloads.student.StudentService;
import at.htl.workloads.teacher.Teacher;
import at.htl.workloads.teacher.TeacherService;
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

        for (Classroom classroom : allClassrooms) {
            for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
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
                    classroomLesson.setTeacher(allTeachers.get(random.nextInt(allTeachers.size())));

                    classroomService.addClassroomLesson(classroomLesson);
                    //classroomLesson.set
                }
            }
        }
    }
}
