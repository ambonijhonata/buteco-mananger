package com.butecomananger.butecomananger.dao;

import com.butecomananger.butecomananger.bancodedados.DatabaseConnection;
import com.butecomananger.butecomananger.model.Cliente;
import com.butecomananger.butecomananger.model.Comanda;

import java.sql.*;

public class ComandaDAO {
    private Connection connection;

    public ComandaDAO() throws SQLException {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    public void abrirComanda(Comanda comanda) throws SQLException {
        String sql = "INSERT INTO comandas (id_cliente, data_hora_abertura) VALUES (?, ?)";
        PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, comanda.getCliente().getCodigo());
        pst.setTimestamp(2, Timestamp.from(comanda.getDataHoraAbertura()));

        int affectedRows = pst.executeUpdate();
        if (affectedRows > 0) {
            try(ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    comanda.setCodigo(rs.getInt(1));
                }
            }
        }

    }

}
