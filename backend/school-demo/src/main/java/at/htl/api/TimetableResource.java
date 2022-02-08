package at.htl.api;

import at.htl.workloads.classroom.Classroom;
import at.htl.workloads.classroom.ClassroomLesson;
import at.htl.workloads.classroom.ClassroomRepository;
import at.htl.workloads.classroom.ClassroomRepositoryImpl;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Path("/timetable")
public class TimetableResource {

    @Inject
    ClassroomRepositoryImpl repo;

    @CheckedTemplate
    public static class Templates{
        public static native TemplateInstance timetable(List<List<ClassroomLesson>> listlist, String className);
    }

    @Path("classroom")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TemplateInstance getTimetableForClassRoomPage(
            @QueryParam("classroomID") int classroomID
    ){
        return Templates.timetable(repo.getTimetable(classroomID), repo.findById(classroomID).getName());
        //return Response.ok(repo.getTimetable(classroomID)).build();
        //return Response.ok(repo.findAll()).build();
    }
    @Path("classroom/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClassrooms(){
        //return Templates.timetable(repo.getTimetable(classroomID));
        return Response.ok(repo.findAll()).build();
    }

    @Path("classroom/spez")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response spez(){
        return Response.ok(repo.findById(1)).build();
    }

    @Path("classroom/spez/spez")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response spezfurther(){

        return Response.ok(repo.getTimetable(1)).build();
    }


}
