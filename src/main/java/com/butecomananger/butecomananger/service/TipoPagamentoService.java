package com.butecomananger.butecomananger.service;

import com.butecomananger.butecomananger.model.TipoPagamento;
import com.butecomananger.butecomananger.repository.TipoPagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPagamentoService {
    private final TipoPagamentoRepository tipoPagamentoRepository;

    public TipoPagamentoService(TipoPagamentoRepository tipoPagamentoRepository) {
        this.tipoPagamentoRepository = tipoPagamentoRepository;
    }

    public List<TipoPagamento> getAll(){
        return tipoPagamentoRepository.findAll();
    }

    public List<TipoPagamento> getByDescricao(String descricao){
        return tipoPagamentoRepository.findByDescricaoContainingIgnoreCase(descricao);
    }


}
