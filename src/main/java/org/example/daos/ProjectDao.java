package org.example.daos;

import org.example.models.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProjectDao {

    public Project getClientHighestValueProject() throws SQLException {


        try(Connection connection = DatabaseConnector.getConnection()){


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
}
