package com.butecomananger.butecomananger.dto;

import com.butecomananger.butecomananger.model.Cliente;
import com.butecomananger.butecomananger.model.TipoPagamento;

import java.time.LocalDateTime;

public record AgendamentoDTO(
        int idCliente,
        LocalDateTime dataInicioAgendamento,
        LocalDateTime dataFimAgendamento,
        int idTipoPagamento
) {
}
