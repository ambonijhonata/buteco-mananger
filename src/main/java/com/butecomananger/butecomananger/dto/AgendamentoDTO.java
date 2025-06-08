package com.butecomananger.butecomananger.dto;

import java.time.LocalDateTime;

public record AgendamentoDTO(

        int idCliente,
        LocalDateTime dataInicioAgendamento,
        LocalDateTime dataFimAgendamento,
        int idTipoPagamento,
        int[] servicos
) {
}
