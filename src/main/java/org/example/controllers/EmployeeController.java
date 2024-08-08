package org.example.controllers;

import org.example.services.EmployeeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GET
    @Path("/{role}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getALlEmployeesByRole(@PathParam("role") String role)
            throws SQLException {
        return Response.ok().entity(employeeService.getEmployeesByRole(role)).build();
    }
}
