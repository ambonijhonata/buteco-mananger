package com.butecomananger.butecomananger.controller;

import com.butecomananger.butecomananger.dto.CreateServicoDTO;
import com.butecomananger.butecomananger.dto.UpdateServicoDTO;
import com.butecomananger.butecomananger.model.Servico;
import com.butecomananger.butecomananger.service.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {
    private ServicoService servicoService;

    public ServicoController(ServicoService servicoService){
        this.servicoService = servicoService;
    }

    @PostMapping
    public ResponseEntity<Servico> criarServico(@RequestBody CreateServicoDTO servicoDto) {
        Servico servico = servicoService.criarServico(servicoDto);
        return ResponseEntity.ok().body(servico);
    }

    @GetMapping
    public ResponseEntity<List<Servico>> getServicos(@RequestParam(required = false) String nome){
        if(nome == null){
            return ResponseEntity.ok().body(servicoService.getAllServicos());
        }

        return ResponseEntity.ok().body(servicoService.getServicoByNome(nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Servico>> delete(@PathVariable Integer id) {
        servicoService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(@RequestBody UpdateServicoDTO servicoDto, @PathVariable int id){
        Servico servico = servicoService.atualizar(id, servicoDto);
        return ResponseEntity.ok().body(servico);
    }
}
