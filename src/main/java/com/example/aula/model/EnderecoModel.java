package com.example.aula.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Classe que define quais campos devem ser criados na tabela do banco de dados.
// Define o nome da tabela, as características dos campos 
// e relacionamento com outras tabelas.

@Entity
@Table(name = "tab_endereco")
public class EnderecoModel {
    // Chave primária e autoincremento.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // O campo na tabela do banco de dados não pode ficar vazio.
    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String numero;

    // Construtor vazio
    // Construtor completo
    // Métodos Getters e Setters
    
    public EnderecoModel() {
    }

    public EnderecoModel(Long id, String logradouro, String numero) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    

    
}
