package org.example.controllers;

import org.example.exceptions.FailedToCreateException;
import org.example.exceptions.InvalidException;
import org.example.models.ProjectRequest;
import org.example.services.ProjectService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/project")
public class ProjectController {
    ProjectService projectService;

    public ProjectController(ProjectService projectService)
    { this.projectService = projectService; }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjects() throws SQLException {
        return Response.ok().entity(projectService.getAllProjects()).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProject(ProjectRequest projectRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(projectService.createProject(projectRequest))
                    .build();
        } catch (FailedToCreateException | SQLException e) {
            System.out.println("Not working");
            return Response.serverError().build();
        } catch (InvalidException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }
}
