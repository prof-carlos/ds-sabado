package com.example.aula.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

// Classe que define quais campos devem ser criados na tabela do banco de dados.
// Define o nome da tabela, as características dos campos 
// e relacionamento com outras tabelas.

@Entity
@Table(name = "tab_cliente")
public class ClienteModel {
    // Chave primária e autoincremento.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // O campo na tabela do banco de dados não pode ficar vazio.
    @Column(nullable = false)
    private String nome;
    
    // O campo na tabela do banco de dados não pode ficar vazio.
    // Este campo não poder ter valores repetidos na tabela.
    @Column(nullable = false, unique = true)
    private String telefone;
    
    // Define relacionamento entre as tabelas "tab_cliente" e "tab_endereco"
    // Um cliente está associado a apenas um endereço
    // Caso exclua um cliente, seu endereço na tabela "tab_endereco" também será excluído.
    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoModel endereco;

    // Construtor vazio
    // Construtor completo
    // Métodos Getters e Setters

    public ClienteModel() {
    }

    public ClienteModel(Long id, String nome, String telefone, EnderecoModel endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    

    
}
