package com.butecomananger.butecomananger.repository;

import com.butecomananger.butecomananger.model.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, Integer> {
    List<TipoPagamento> findByDescricaoContainingIgnoreCase(String descricao);
    List<TipoPagamento> findAllByOrderByIdAsc();
}
