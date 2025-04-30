package com.butecomananger.butecomananger;

import com.butecomananger.butecomananger.bancodedados.DatabaseConnection;
import com.butecomananger.butecomananger.dao.ClienteDAO;
import com.butecomananger.butecomananger.dao.ComandaDAO;
import com.butecomananger.butecomananger.model.Cliente;
import com.butecomananger.butecomananger.model.Comanda;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class ButecoManangerApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(ButecoManangerApplication.class, args);
    }

}
