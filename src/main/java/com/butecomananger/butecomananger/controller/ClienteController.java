package com.butecomananger.butecomananger.controller;

import com.butecomananger.butecomananger.dto.ClienteDTO;
import com.butecomananger.butecomananger.model.Cliente;
import com.butecomananger.butecomananger.repository.ClienteRepository;
import com.butecomananger.butecomananger.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteService = new ClienteService(clienteRepository);
    }

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody @Valid ClienteDTO clientedto) throws SQLException {
        Cliente cliente = clienteService.criarCliente(clientedto);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes(@RequestParam(required = false) String nome){
        if(nome == null){
            return ResponseEntity.ok().body(clienteService.getTodosClientes());
        }
        return ResponseEntity.ok().body(clienteService.getClienteByNome(nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id){
        clienteService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO){
        Cliente cliente = clienteService.atualizar(id, clienteDTO);
        return ResponseEntity.ok().body(cliente);
    }


}
