package com.butecomananger.butecomananger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class ButecoManangerApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(ButecoManangerApplication.class, args);
    }

}
