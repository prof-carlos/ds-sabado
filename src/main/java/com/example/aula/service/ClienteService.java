package com.example.aula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula.model.ClienteModel;
import com.example.aula.repository.ClienteRepository;

// Classe para validar regras da empresa (negócio).
// Exemplo: Não permtir salvar os dados do mesmo cliente duas vezes.

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> listarTodos() {
        return clienteRepository.findAll();
    }

    public ClienteModel salvarCliente(ClienteModel cliente) {
        // Consulta se os dados enviados do cliente existem no banco de dados.
        // Caso encontre algum telefone igual ao enviado, envia uma mensagem
        // "Cliente já cadastrado."
        if (clienteRepository.findByTelefone(cliente.getTelefone()).isPresent()) {
            throw new IllegalArgumentException("Cliente já cadastrado.");
        }
        return clienteRepository.save(cliente);
    }

    public ClienteModel atualizarCliente(Long id, ClienteModel cliente) {
        // Consulta se os dados enviados do cliente existem no banco de dados.
        // Caso não encontre antes de atualizar, envia uma mensagem
        // "Cliente não encontrado"
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado.");
        }
        cliente.setId(id); // Define os novos dados enviados para o id de um cliente existente.
        cliente.getEndereco().setId(id); // Associa os novos dados de endereço ao mesmo usuário.
        return clienteRepository.save(cliente); // Comando save funciona para salvar e atualizar.
    }

    public void excluirCliente(Long id) {
        // Consulta se os dados enviados do cliente existem no banco de dados.
        // Caso não encontre antes de excluir, envia uma mensagem
        // "Cliente não encontrado"
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado.");
        }
        clienteRepository.deleteById(id);
    }


}
