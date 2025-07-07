package com.butecomananger.butecomananger.dto;

import jakarta.validation.constraints.NotBlank;

public class ClienteDTO {
    @NotBlank(message = "O nome do cliente é obrigatorio")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
