package com.butecomananger.butecomananger.service;

import com.butecomananger.butecomananger.dto.ClienteDTO;
import com.butecomananger.butecomananger.model.Cliente;
import com.butecomananger.butecomananger.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());

        return clienteRepository.save(cliente);
    }

    public List<Cliente> getTodosClientes() {
        return clienteRepository.findAll();
    }

    public List<Cliente> getClienteByNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    public void delete(int id) {
        if(!clienteRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }

    public Cliente atualizar(int id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        cliente.setNome(clienteDTO.getNome());
        return clienteRepository.save(cliente);
    }

}
