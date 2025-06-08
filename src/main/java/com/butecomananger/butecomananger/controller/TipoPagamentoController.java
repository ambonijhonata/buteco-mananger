package com.butecomananger.butecomananger.controller;

import com.butecomananger.butecomananger.model.TipoPagamento;
import com.butecomananger.butecomananger.service.TipoPagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
