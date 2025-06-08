package com.butecomananger.butecomananger.service;

import com.butecomananger.butecomananger.dto.AgendamentoDTO;
import com.butecomananger.butecomananger.model.Agendamento;
import com.butecomananger.butecomananger.model.Cliente;
import com.butecomananger.butecomananger.model.TipoPagamento;
import com.butecomananger.butecomananger.repository.AgendamentoRepository;
import com.butecomananger.butecomananger.repository.ClienteRepository;
import com.butecomananger.butecomananger.repository.TipoPagamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AgendamentoService {

    private AgendamentoRepository agendamentoRepository;
    private ClienteRepository clienteRepository;
    private TipoPagamentoRepository tipoPagamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, ClienteRepository clienteRepository, TipoPagamentoRepository tipoPagamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.clienteRepository = clienteRepository;
        this.tipoPagamentoRepository = tipoPagamentoRepository;
    }

    @Transactional
    public Agendamento criarAgendamento(AgendamentoDTO agendamentoDTO) {
        Cliente cliente = clienteRepository.findById(agendamentoDTO.idCliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        TipoPagamento tipoPagamento = tipoPagamentoRepository.findById(agendamentoDTO.idTipoPagamento())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de pagamento não encontrado"));

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setDataInicioAgendamento(agendamentoDTO.dataInicioAgendamento());
        agendamento.setDataFimAgendamento(agendamentoDTO.dataFimAgendamento());
        agendamento.setTipoPagamento(tipoPagamento);

        agendamento = agendamentoRepository.save(agendamento);
        return agendamentoRepository.save(agendamento);
    }

    public void delete(int id) {
        if(!agendamentoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado");
        }
        agendamentoRepository.deleteById(id);
    }


    public List<Agendamento> buscarPorCliente(int codigoCliente) {
        if(!clienteRepository.existsById(codigoCliente)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }

        return agendamentoRepository.findByClienteCodigo(codigoCliente);
    }

    public List<Agendamento> buscarTodos() {
        return  agendamentoRepository.findAll();
    }
}
