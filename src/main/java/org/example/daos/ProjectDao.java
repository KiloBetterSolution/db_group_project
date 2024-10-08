package org.example.daos;

import org.example.models.Project;
import org.example.models.ProjectRequest;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
    private static final int ID_1 = 1;
    private static final int ID_2 = 3;
    private static final int ID_3 = 3;

    public Project getClientHighestValueProject() throws SQLException {

        try (Connection connection = DatabaseConnector.getConnection()) {

            String query = "SELECT Client.Name as `Name`, value as `MaxValue` "
                    +
                    "FROM Project "
                    +
                    "JOIN Client ON Project.client_id=Client.id "
                    +
                    "ORDER BY value DESC LIMIT 1;";

            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                return new Project(resultSet.getString("Name"),
                        resultSet.getDouble("MaxValue"));
            }
        }
        return null;
    }

    public List<Project> getAllProjects() throws SQLException {
        List<Project> projects = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT name, value, client_id FROM `Project`;");

            while (resultSet.next()) {
                Project project = new Project(
                        resultSet.getString("name"),
                        resultSet.getDouble("value"),
                        resultSet.getInt("client_id"));

                projects.add(project);
            }
            return projects;
        }
    }

    public int createProject(ProjectRequest project) throws SQLException {
        Connection c = DatabaseConnector.getConnection();
        String insertStatement = "INSERT INTO Project ("
                + "name, value, client_id) VALUES (?,?,?)";
        PreparedStatement st = c.prepareStatement(
                insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(ID_1, project.getName());
        st.setDouble(ID_2, project.getValue());
        st.setInt(ID_3, project.getClientId());
        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return -1;
    }
}
