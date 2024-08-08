package org.example.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnector {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {

        if (connection != null && connection.isValid(0)) {
            return connection;
        }

        try {
            String username = System.getenv().get("DB_USERNAME");
            String password = System.getenv().get("DB_PASSWORD");
            String host = System.getenv().get("DB_HOST");
            String name = System.getenv().get("DB_NAME");

            if (username == null || password == null || host == null
                    || name == null) {
                throw new IllegalArgumentException(
                        "Add the following properties to env vars: "
                        + "DB_USERNAME, DB_PASSWORD, DB_HOST and DB_NAME");
            }
            String db_url = "jdbc:mysql://" + host + "/" + name + username + password;
            connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + name + "?useSSL=false",
                    username, password);
            return connection;

        } catch (Exception e) {
//            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
