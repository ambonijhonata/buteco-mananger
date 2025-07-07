package com.butecomananger.butecomananger.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoPagamentoDTO {
    @NotBlank(message = "A descrição do tipo de pagamento é obrigatoria")
    private String descricao;
    @NotNull(message = "A taxa do tipo de pagamento é obrigatoria")
    private BigDecimal taxa;
}
