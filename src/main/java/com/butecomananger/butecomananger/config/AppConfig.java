package com.butecomananger.butecomananger.config;

import com.butecomananger.butecomananger.bancodedados.DatabaseConnection;
import com.butecomananger.butecomananger.dao.ClienteDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class AppConfig {

    @Bean
    public DatabaseConnection databaseConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }

    @Bean
    public ClienteDAO clienteDAO(DatabaseConnection databaseConnection) throws SQLException {
        return new ClienteDAO();
    }
}
