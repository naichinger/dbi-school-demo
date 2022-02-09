package at.htl.api;

import at.htl.model.StudentCountDTO;
import at.htl.model.TeacherHourCountDTO;
import at.htl.workloads.classroom.Classroom;
import at.htl.workloads.classroom.ClassroomService;
import at.htl.workloads.teacher.Teacher;
import at.htl.workloads.teacher.TeacherService;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/classroom")
public class ClassroomResource {

    @Inject
    ClassroomService classroomService;

    @Inject
    TeacherService teacherService;

    @CheckedTemplate
    public static class Templates{
        public static native TemplateInstance classroom(List<Classroom> classes);
        public static native TemplateInstance classWithStudentCount(List<StudentCountDTO> classWithStudentCounts);
        public static native TemplateInstance teacherWithStudentCount(
                List<TeacherHourCountDTO> teacherWithStudentsCount,
                List<Teacher> teachers,
                String teachername
        );

    }

    @GET
    public TemplateInstance getClassroomAllPage(){
        return Templates.classroom(classroomService.findAll());
    }

    @GET
    @Path("/studentcount/")
    public TemplateInstance getClassWithStudentCountPage(){
        return Templates.classWithStudentCount(classroomService.getClassWithStudentCount());
    }


    @GET
    @Path("/teachercount/")
    public TemplateInstance getTeacherWithStudentCountPage(
            @QueryParam("id") Long teacherId
    ){
        return Templates.teacherWithStudentCount(
                classroomService.getTeacherWithStudentsCount(teacherId),
                teacherService.findAll(),
                teacherService.findById(teacherId).toString()
        );
    }



}
