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

    // ex. 2,4
    @GET
    @Path("/{role}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getALlEmployeesByRole(@PathParam("role") String role)
            throws SQLException {
        try {
            return Response.ok().entity(employeeService.getEmployeesByRole(
                    role)).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("SQL issue. " + e.getMessage()).build();
        }
    }


    //ex. 13, 16 - to search specific employee, you need just id. Adding role
    // won't change anything
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeById(@PathParam("id") int id)
            throws SQLException {
        try {
            return Response.ok().entity(employeeService.getEmployeeById(id))
                    .build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("SQL issue. " + e.getMessage()).build();
        }
    }
}
