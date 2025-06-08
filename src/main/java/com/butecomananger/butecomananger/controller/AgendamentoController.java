package com.butecomananger.butecomananger.controller;

import com.butecomananger.butecomananger.dto.AgendamentoDTO;
import com.butecomananger.butecomananger.model.Agendamento;
import com.butecomananger.butecomananger.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamento")
public class AgendamentoController {
    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping
    public ResponseEntity<?> criarAgendamento(@RequestBody AgendamentoDTO agendamentoDTO){
        Agendamento agendamento = agendamentoService.criarAgendamento(agendamentoDTO);

        return new ResponseEntity<>(agendamento, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Agendamento>> listarAgendamentos(@RequestParam(required = false) Integer cliente){
        if(cliente == null){
            return ResponseEntity.ok().body(agendamentoService.buscarTodos());
        }

        return ResponseEntity.ok().body(agendamentoService.buscarPorCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        agendamentoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
