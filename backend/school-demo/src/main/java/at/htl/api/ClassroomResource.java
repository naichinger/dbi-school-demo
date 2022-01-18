package at.htl.api;

import at.htl.model.ClassroomDTO;
import at.htl.workloads.classroom.Classroom;
import at.htl.workloads.classroom.ClassroomLesson;
import at.htl.workloads.classroom.ClassroomService;
import io.quarkus.resteasy.runtime.QuarkusRestPathTemplate;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.DayOfWeek;
import java.util.List;

@Path("/classroom")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClassroomResource {
    private final ClassroomService classroomService;

    public ClassroomResource(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GET
    public Response findAll() {
        return Response.ok(classroomService.findAll()).build();
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") long id) {
        return Response.ok(classroomService.findById(id)).build();
    }

    @POST
    @Transactional
    public Response add(ClassroomDTO classroomDTO) {
        return Response.ok(classroomService.addClassroom(
                classroomDTO.getName(),
                classroomDTO.getTeacherId(),
                classroomDTO.getRoomId(),
                classroomDTO.getStudentIds(),
                classroomDTO.getLessonIds(),
                classroomDTO.getTestIds())
        ).build();
    }

    @POST
    @Path("{id}/update")
    @Transactional
    public Response update(@PathParam("id") long id, ClassroomDTO classroomDTO) {
        Classroom classroom = classroomService.findById(id);

        if (classroom == null) {
            return Response.status(404).build();
        }

        return Response.ok(classroomService.updateClassroom(classroom,
                classroomDTO.getName(),
                classroomDTO.getTeacherId(),
                classroomDTO.getRoomId(),
                classroomDTO.getStudentIds(),
                classroomDTO.getLessonIds(),
                classroomDTO.getTestIds())).build();
    }

    @POST
    @Path("{id}/remove")
    @Transactional
    public Response remove(@PathParam("id") long id) {
        Classroom classroom = classroomService.findById(id);

        if (classroom == null) {
            return Response.status(404).build();
        }
        classroomService.removeClassroom(classroom);
        return Response.ok().build();
    }

    @GET
    @Path("{id}/lesson/{dayOfWeek}")
    public Response getLessonsForDayOfWeek(@PathParam("id") long id, @PathParam("dayOfWeek") DayOfWeek dayOfWeek) {
        Classroom classroom = classroomService.findById(id);

        if (classroom == null) {
            return Response.status(404).build();
        }

        return Response.ok(classroomService.getLessonsForDayOfWeek(classroom, dayOfWeek)).build();
    }
}
