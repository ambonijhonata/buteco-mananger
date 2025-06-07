package com.butecomananger.butecomananger.dto;

import java.math.BigDecimal;

public record CreateServicoDTO(
        String nome,
        String descricao,
        BigDecimal valor
) {
}
