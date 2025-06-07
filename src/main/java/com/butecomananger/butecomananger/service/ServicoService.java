package com.butecomananger.butecomananger.service;

import com.butecomananger.butecomananger.dto.CreateServicoDTO;
import com.butecomananger.butecomananger.dto.UpdateServicoDTO;
import com.butecomananger.butecomananger.model.Servico;
import com.butecomananger.butecomananger.repository.ServicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServicoService {

    private ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public Servico criarServico(CreateServicoDTO servicoDto) {
        Servico servico = new Servico();
        servico.setNome(servicoDto.nome());
        servico.setDescricao(servicoDto.descricao());
        servico.setValor(servicoDto.valor());

        return servicoRepository.save(servico);
    }

    public List<Servico> getAllServicos() {
        return servicoRepository.findAll();
    }

    public List<Servico> getServicoByNome(String nomeServico) {
        return servicoRepository.findByNomeContainingIgnoreCase(nomeServico);
    }

    public void delete(int id) {
        if(!servicoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado");
        }

        servicoRepository.deleteById(id);
    }

    public Servico atualizar(int id, UpdateServicoDTO servicoDto) {
        Servico servico = servicoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado"));

        servico.setNome(servicoDto.nome());
        servico.setDescricao(servicoDto.descricao());
        servico.setValor(servicoDto.valor());
        return servicoRepository.save(servico);
    }
}
