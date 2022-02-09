package at.htl.api;

import at.htl.workloads.classroom.Classroom;
import at.htl.workloads.classroom.ClassroomService;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/classroom")
public class ClassroomResource {

    @Inject
    ClassroomService classroomService;

    @CheckedTemplate
    public static class Templates{
        public static native TemplateInstance classroom(List<Classroom> classes);
    }

    @GET
    public TemplateInstance getClassroomAllPage(){
        return Templates.classroom(classroomService.findAll());
    }

}
