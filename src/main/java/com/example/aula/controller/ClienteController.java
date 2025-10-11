package com.example.aula.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula.model.ClienteModel;
import com.example.aula.service.ClienteService;

// Interface de comunicação com clientes da API.
// Cria endpoint "/clientes" para acesso via clientes de API.

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Read - Pesquisar todos os clientes.
    @GetMapping
    public List<ClienteModel> listar() {
        return clienteService.listarTodos(); 
    }

    // {chave : valor}
    // Map<String, Object>
    // Map.of("mensagem", "Cadastrado com sucesso.")

    // Create - Salvar.
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody ClienteModel cliente) {

        clienteService.salvarCliente(cliente);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Cadastrado com sucesso."));
    }

    // Update - Atualizar.
    // Exemplo: PUT - http://localhost:8080/clientes/1
    // Recebe o id do cliente no endpoint para usar como variável e consultar no banco de dados.
    // Atualiza os dados apenas do cliente com id 1 no banco de dados.
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(
        @PathVariable Long id, @RequestBody ClienteModel cliente) {

        clienteService.atualizarCliente(id, cliente);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Atualizado com sucesso."));
    }

    // Delete - Excluir.
    // Exemplo: DELETE - http://localhost:8080/clientes/1
    // Recebe o id do cliente no endpoint para usar como variável e consultar no banco de dados.
    // Exclui os dados apenas do cliente com id 1 no banco de dados.
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> exclulir(@PathVariable Long id) {
        clienteService.excluirCliente(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Excluído com sucesso."));
    }
}
