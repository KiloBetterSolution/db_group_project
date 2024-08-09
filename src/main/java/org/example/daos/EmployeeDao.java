package org.example.daos;

import org.example.models.Employee;
import org.example.models.EmployeeRequest;
import org.example.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private static final int ID_1 = 1;
    private static final int ID_2 = 2;
    private static final int ID_3 = 3;
    private static final int ID_4 = 4;

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

        PreparedStatement st = c.prepareStatement(insertStatement,
                Statement.RETURN_GENERATED_KEYS);

        st.setString(ID_1, employee.getName());
        st.setDouble(ID_2, employee.getSalary());
        st.setString(ID_3, employee.getBankAccountNumber());
        st.setString(ID_4, employee.getNationalInsuranceNumber());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public Employee getEmployeeById(int id) throws SQLException {

        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT Employee.id, name, salary, "
                    + "bank_account_number, "
                    + "national_insurance_number, "
                    + "Role.role FROM Employee LEFT JOIN Employee_Role "
                    + "ON Employee.id = "
                    + "Employee_Role.employee_id LEFT JOIN `Role` ON "
                    + "Employee_Role.role_id "
                    + "= `Role`.id WHERE Employee.id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String roleName = resultSet.getString("Role.role");
                return new Employee(
                        resultSet.getInt("Employee.id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("bank_account_number"),
                        resultSet.getString("national_insurance_number"),
                        Role.valueOf(roleName)
                );
            }
        }
        return null;
    }
}
