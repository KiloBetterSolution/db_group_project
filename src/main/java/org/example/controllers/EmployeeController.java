package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.exceptions.FailedToCreateException;
import org.example.exceptions.InvalidException;
import org.example.models.EmployeeRequest;
import org.example.services.EmployeeService;

import javax.ws.rs.*;
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

    @GET
    @Path("/{role}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getALlEmployeesByRole(@PathParam("role") String role)
            throws SQLException {
        return Response.ok().entity(employeeService.getEmployeesByRole(
                role)).build();
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
