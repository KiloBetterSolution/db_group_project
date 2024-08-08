package org.example.controllers;

import org.example.services.ProjectService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/project")
public class ProjectController {
    ProjectService projectService;

    public ProjectController(ProjectService projectService) { this.projectService = projectService; }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProjects() throws SQLException {
        return Response.ok().entity(projectService.getAllProjects()).build();
    }
}
