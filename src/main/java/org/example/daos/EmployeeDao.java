package org.example.daos;

import org.example.models.Employee;
import org.example.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public List<Employee> getAllEmployeeByRole(String role) throws SQLException {
        List<Employee> employeeList = new ArrayList<>();

        try(Connection connection = DatabaseConnector.getConnection()) {

            String query = "SELECT id, name, salary, bank_account_number, national_insurance_number, Role.role FROM Employee LEFT JOIN Employee_Role ON Employee.id = Employee_Role.employee_id LEFT JOIN `Role` ON Employee_Role.role_id = `Role`.id WHERE `role` = ?;";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, role);

            ResultSet resultSet = statement.executeQuery();

            String roleName = resultSet.getString("role");

            while (resultSet.next()) {
                Employee employee = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("bank_account_number"),
                        resultSet.getString("national_insurance_number"),
                        Role.valueOf(roleName)
                        );

                employeeList.add(employee);
            }
        }

        return employeeList;
    }
}
