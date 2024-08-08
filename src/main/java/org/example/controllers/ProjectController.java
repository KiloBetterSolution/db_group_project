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

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GET
    @Path("/max")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientHighestValueProject()
            throws SQLException {
        return Response.ok().entity(projectService.getHighestValueProject())
                .build();
    }
}
