package com.butecomananger.butecomananger.dao;

import com.butecomananger.butecomananger.bancodedados.DatabaseConnection;
import com.butecomananger.butecomananger.model.Cliente;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO() throws SQLException {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    public void inserir(Cliente cliente) throws SQLException {

        String sql = "INSERT INTO clientes (nome) VALUES (?)";

        PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, cliente.getNome());

        int affectedRows = pst.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    cliente.setCodigo(rs.getInt(1));
                    cliente.setNome(rs.getString(2));
                }
            }
        }

    }

    public Cliente buscarByNome(String nome) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE nome = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, nome);

        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setCodigo(rs.getInt(1));
            cliente.setNome(rs.getString(2));

            return cliente;
        }

        return null;
    }
}
