package com.butecomananger.butecomananger.bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection databaseConnection;
    private Connection connection;

    private static final String URL = "jdbc:postgresql://localhost:5432/buteco";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";

    private DatabaseConnection() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new SQLException("Erro ao se conectar o banco de dados: " + e.getMessage());
        }
    }

    public static DatabaseConnection getInstance()  throws SQLException {
        if(databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }

        return databaseConnection;
    }

    public static void closeDatabaseConnection() throws SQLException {
        if(databaseConnection != null && !databaseConnection.connection.isClosed()) {
            databaseConnection.connection.close();
        }
    }

    public Connection getConnection() throws SQLException {
        return connection;
    }

}
