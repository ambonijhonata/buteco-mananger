package com.butecomananger.butecomananger.controller;

import com.butecomananger.butecomananger.dto.TipoPagamentoDTO;
import com.butecomananger.butecomananger.model.TipoPagamento;
import com.butecomananger.butecomananger.service.TipoPagamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-pagamento")
public class TipoPagamentoController {
    private TipoPagamentoService tipoPagamentoService;

    public TipoPagamentoController(TipoPagamentoService tipoPagamentoService) {
        this.tipoPagamentoService = tipoPagamentoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoPagamento>> get(@RequestParam(required = false) String descricao ){
        if(descricao == null){
            return ResponseEntity.ok(tipoPagamentoService.getAll());
        }
        return ResponseEntity.ok(tipoPagamentoService.getByDescricao(descricao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPagamento> update(@PathVariable Integer id, @RequestBody @Valid TipoPagamentoDTO tipoPagamentoDTO) {
        TipoPagamento tipoPagamentoEntity = tipoPagamentoService.update(id, new TipoPagamento(tipoPagamentoDTO.getDescricao(), tipoPagamentoDTO.getTaxa()));
        return ResponseEntity.ok().body(tipoPagamentoEntity);
    }
}
