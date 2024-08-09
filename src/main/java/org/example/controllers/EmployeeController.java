package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.FailedToCreateException;
import org.example.exceptions.InvalidException;
import org.example.models.EmployeeRequest;
import org.example.services.EmployeeService;

import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Engineering Academy Dropwizard Order API")
@Path("employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ex. 2,4
    @GET
    @Path("/roles/{role}")
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

//    1. As a member of the HR team I want to be able to create a new delivery
//    employee. I should be able to store a name, salary, bank account number
//    and national insurance number
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEmployee(EmployeeRequest employeeRequest) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(employeeService.createEmployee(employeeRequest))
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
