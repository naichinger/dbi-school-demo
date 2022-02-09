package at.htl.api;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/api")
public class ClassroomApi {

    @Path("classroom")
    @POST
    public Response getTimetableForClass(
            @FormParam("teacherOption") long teacherID
    ){
        return Response.status(301).location(URI.create("/classroom/teachercount/?id=" + teacherID)).build();
    }
}
