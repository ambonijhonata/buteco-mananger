package com.butecomananger.butecomananger.controller;

import com.butecomananger.butecomananger.dao.ClienteDAO;
import com.butecomananger.butecomananger.dto.ClienteDTO;
import com.butecomananger.butecomananger.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteDAO clienteDAO;

    public ClienteController(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody ClienteDTO clientedto) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setNome(clientedto.getNome());

        clienteDAO.inserir(cliente);
        return ResponseEntity.ok().body(cliente);
    }

}
