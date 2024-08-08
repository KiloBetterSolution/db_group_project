package org.example.services;

import org.example.daos.EmployeeDao;
import org.example.models.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> getEmployeesByRole(String role) throws SQLException {
        return employeeDao.getAllEmployeeByRole(role);
    }
}
