package com.example.aula.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aula.model.ClienteModel;

// Classe que permite realizar CRUD no banco de dados.
// Exemplo: salvar, atualizar, excluir, consultar entre outors.

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    // Consultar no banco de dados se o telefone já existe 
    // antes de salvar um novo cliente.
    Optional<ClienteModel> findByTelefone(String telefone);
}
