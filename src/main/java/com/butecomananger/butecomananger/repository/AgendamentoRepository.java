package com.butecomananger.butecomananger.repository;

import com.butecomananger.butecomananger.model.Agendamento;
import com.butecomananger.butecomananger.model.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Integer> {
    List<Agendamento> findByTipoPagamento(TipoPagamento tipoPagamento);
    List<Agendamento> findByClienteCodigo(int codigoCliente);

}
