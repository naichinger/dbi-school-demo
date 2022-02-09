package at.htl.api;

import at.htl.workloads.classroom.Classroom;
import at.htl.workloads.classroom.ClassroomLesson;
import at.htl.workloads.classroom.ClassroomRepositoryImpl;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Path("/timetable")
public class TimetableResource {

    @Inject
    ClassroomRepositoryImpl repo;

    @CheckedTemplate
    public static class Templates{
        public static native TemplateInstance timetable(
                List<List<ClassroomLesson>> listlist,
                String className,
                List<Classroom> classes,
                List<DayOfWeek> dayOfWeeks);
    }

    @Path("classroom")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TemplateInstance getTimetableForClassRoomPage(
            @QueryParam("classroomID") int classroomID
    ){

        List<DayOfWeek> days = new ArrayList<>();
        days.add(DayOfWeek.MONDAY);
        days.add(DayOfWeek.TUESDAY);
        days.add(DayOfWeek.WEDNESDAY);
        days.add(DayOfWeek.THURSDAY);
        days.add(DayOfWeek.FRIDAY);


        return Templates.timetable(
                repo.getTimetable(classroomID),
                repo.findById(classroomID).getName(),
                repo.findAll(),
                days
        );
        //return Response.ok(repo.getTimetable(classroomID)).build();
        //return Response.ok(repo.findAll()).build();
    }


}
