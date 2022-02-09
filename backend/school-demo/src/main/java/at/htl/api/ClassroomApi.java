package at.htl.api;

import at.htl.model.ClassroomDTO;
import at.htl.workloads.classroom.Classroom;
import at.htl.workloads.classroom.ClassroomService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.time.DayOfWeek;

@Path("/api")
public class ClassroomApi {

    private final ClassroomService classroomService;

    @Path("classroom")
    @POST
    public Response getTimetableForClass(
            @FormParam("teacherOption") long teacherID
    ){
        return Response.status(301).location(URI.create("/classroom/teachercount/?id=" + teacherID)).build();
    }

    public ClassroomApi(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GET
    @Path("classroom/all")
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
    @Path("/classroom/add")
    public Response add(ClassroomDTO classroomDTO) {
        return Response.ok(classroomService.addClassroom(
                classroomDTO.getName(),
                classroomDTO.getTeacherId(),
                classroomDTO.getRoomId(),
                classroomDTO.getStudentIds())
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
                classroomDTO.getStudentIds())).build();
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
