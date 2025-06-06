package com.butecomananger.butecomananger.repository;

import com.butecomananger.butecomananger.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    List<Cliente> findByNomeContainingIgnoreCase (String nome);
}
