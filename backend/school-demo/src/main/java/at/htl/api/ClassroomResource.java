package at.htl.api;

import at.htl.model.ClassroomDTO;
import at.htl.workloads.classroom.Classroom;
import at.htl.workloads.classroom.ClassroomService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/classroom")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClassroomResource {
    @Inject
    ClassroomService classroomService;

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
    public Response add(ClassroomDTO classroomDTO) {
        return Response.ok(classroomService.addClassroom(
                classroomDTO.getName(),
                classroomDTO.getTeacherId(),
                classroomDTO.getRoomId(),
                classroomDTO.getStudentIds())
        ).build();
    }

    @POST
    @Path("{id}/remove")
    public Response remove(@PathParam("id") long id) {
        Classroom classroom = classroomService.findById(id);

        if (classroom == null) {
            return Response.status(404).build();
        }
        classroomService.removeClassroom(classroom);
        return Response.ok().build();
    }

    @POST
    @Path("{id}/update")
    public Response update(@PathParam("id") long id, ClassroomDTO classroomDTO) {
        Classroom classroom = classroomService.findById(id);

        if (classroom == null) {
            return Response.status(404).build();
        }

        Classroom newClassroom = classroomService.updateClassroom(id,
                classroomDTO.getName(),
                classroomDTO.getTeacherId(),
                classroomDTO.getRoomId(),
                classroomDTO.getStudentIds());
        return Response.ok(newClassroom).build();
    }
}
