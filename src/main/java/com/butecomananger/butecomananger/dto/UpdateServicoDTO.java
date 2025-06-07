package com.butecomananger.butecomananger.dto;

import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

public record UpdateServicoDTO(
        String nome,
        String descricao,
        @Min(value = 0, message = "O valor nao pode ser negativo")
        BigDecimal valor
) {
}
