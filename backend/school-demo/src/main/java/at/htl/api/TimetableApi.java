package at.htl.api;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/api")
public class TimetableApi {

    @Path("timetable")
    @POST
    public Response getTimetableForClass(
            @FormParam("classOption") long classID
    ){
        return Response.status(301).location(URI.create("/timetable/classroom/?classroomID=" + classID)).build();
    }
}
