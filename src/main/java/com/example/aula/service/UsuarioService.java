package com.example.aula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.aula.dto.UsuarioRequestDTO;
import com.example.aula.dto.UsuarioResponseDTO;
import com.example.aula.model.UsuarioModel;
import com.example.aula.repository.UsuarioRepository;

@Service
public class UsuarioService {
 
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Consultar usuários.
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository
            .findAll() // Busca todos os usuários no BD.
            .stream() // Direciona o resultado anterior para os próximos comandos.
            .map(u -> new UsuarioResponseDTO(u.getNome(), u.getEmail())) // Exibir apenas nome e email.
            .toList(); // Mostrar em forma de lista.
    }

    // Salvar usuário.
    public UsuarioModel salvarUsuario(UsuarioRequestDTO dto) {
        // Verifica se o usuário já está cadastrado no banco de dados.
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Usuário já cadastrado.");
        }

        // Os dados validados do usuário serão adicionados na classe que salva no BD.
        UsuarioModel novoUsuario = new UsuarioModel();
        novoUsuario.setNome(dto.getNome());
        novoUsuario.setEmail(dto.getEmail());
        novoUsuario.setSenha(passwordEncoder.encode(dto.getSenha())); // Criptografando a senha.

        usuarioRepository.save(novoUsuario); // Salvando os dados do usuário.
        return novoUsuario;
    }

}
