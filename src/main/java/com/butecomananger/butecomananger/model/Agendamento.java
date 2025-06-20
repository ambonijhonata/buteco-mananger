package com.butecomananger.butecomananger.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agendamentos")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "data_inicio_agendamento", nullable = false)
    private LocalDateTime dataInicioAgendamento;

    @Column(name = "data_fim_agendamento", nullable = false)
    private LocalDateTime dataFimAgendamento;

    @ManyToOne
    @JoinColumn(name = "id_pagamento", nullable = false)
    private TipoPagamento tipoPagamento;

    @ManyToMany
    @JoinTable(
            name = "agendamento_servico",
            joinColumns = @JoinColumn(name = "id_agendamento"),
            inverseJoinColumns =  @JoinColumn(name = "id_servico"),
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {"id_agendamento", "id_servico"},
                    name = "uk_agendamento_servico"
            )
    )
    private List<Servico> servicos = new ArrayList<>();

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDataInicioAgendamento(LocalDateTime dataInicioAgendamento) {
        this.dataInicioAgendamento = dataInicioAgendamento;
    }

    public void setDataFimAgendamento(LocalDateTime dataFimAgendamento) {
        this.dataFimAgendamento = dataFimAgendamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public Integer getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getDataInicioAgendamento() {
        return dataInicioAgendamento;
    }

    public LocalDateTime getDataFimAgendamento() {
        return dataFimAgendamento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public List<Servico> getServicos() {
        return servicos;
    }
}
