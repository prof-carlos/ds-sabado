package com.example.aula.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula.dto.UsuarioRequestDTO;
import com.example.aula.dto.UsuarioResponseDTO;
import com.example.aula.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // Consultar todos usuário no banco de dados.
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        return ResponseEntity
                .ok()
                .body(usuarioService.listarTodos());
    }

    // Salvar novo usuário.
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody UsuarioRequestDTO dto) {
        usuarioService.salvarUsuario(dto);
        return ResponseEntity
                .created(null)
                .body(Map.of(
                    "mensagem", "Usuário cadastrado com sucesso.",
                    "sucesso", true
                ));
    }


}
