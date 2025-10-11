package com.example.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aula.model.EnderecoModel;

// Classe que permite realizar CRUD no banco de dados.
// Exemplo: salvar, atualizar, excluir, consultar entre outors.

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {
}
