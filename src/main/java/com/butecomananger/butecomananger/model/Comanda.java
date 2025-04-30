package com.butecomananger.butecomananger.model;

import java.time.Instant;

public class Comanda {
    private int codigo;
    private Cliente cliente;
    private Instant dataHoraAbertura;
    private Instant dataHoraFechamento;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Instant getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(Instant dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public Instant getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(Instant dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }

}
