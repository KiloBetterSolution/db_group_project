package org.example.daos;

import org.example.models.Employee;
import org.example.models.EmployeeRequest;
import org.example.models.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public List<Employee> getAllEmployeeByRole(String role)
            throws SQLException {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {

            String query = "SELECT Employee.id, name, salary, "
                    + "bank_account_number, "
                    + "national_insurance_number, "
                    + "Role.role FROM Employee LEFT JOIN Employee_Role "
                    + "ON Employee.id = "
                    + "Employee_Role.employee_id LEFT JOIN `Role` ON "
                    + "Employee_Role.role_id "
                    + "= `Role`.id WHERE `role` = ?;";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, role);

            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {

                String roleName = resultSet.getString("Role.role");
                Employee employee = new Employee(
                        resultSet.getInt("Employee.id"),
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


    public int createEmployee(EmployeeRequest employee) throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String insertStatement = "INSERT INTO `Employee` (name, salary, "
                + "bank_account_number, "
                + "national_insurance_number) VALUES (?,?,?,?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, employee.getName());
        st.setDouble(2, employee.getSalary());
        st.setString(3, employee.getBankAccountNumber());
        st.setString(4, employee.getNationalInsuranceNumber());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

}
