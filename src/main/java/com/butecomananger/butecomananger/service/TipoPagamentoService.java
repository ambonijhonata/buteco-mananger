package com.butecomananger.butecomananger.service;

import com.butecomananger.butecomananger.dto.TipoPagamentoDTO;
import com.butecomananger.butecomananger.model.TipoPagamento;
import com.butecomananger.butecomananger.repository.TipoPagamentoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TipoPagamentoService {
    private final TipoPagamentoRepository tipoPagamentoRepository;

    public TipoPagamentoService(TipoPagamentoRepository tipoPagamentoRepository) {
        this.tipoPagamentoRepository = tipoPagamentoRepository;
    }

    public List<TipoPagamento> getAll(){
        return tipoPagamentoRepository.findAllByOrderByIdAsc();
    }

    public List<TipoPagamento> getByDescricao(String descricao){
        return tipoPagamentoRepository.findByDescricaoContainingIgnoreCase(descricao);
    }

    public TipoPagamento update(int id, TipoPagamento tipoPagamento) {
        tipoPagamentoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo pagamento não encontrado"));

        tipoPagamento.setId(id);
        return tipoPagamentoRepository.save(tipoPagamento);
    }
}
