package com.example.aula.controller;

import com.example.aula.model.Usuario;
import com.example.aula.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String exibirFormulario(Model model) {
        model.addAttribute("usuario", new Usuario()); // Passa um objeto vazio para o formulário
        return "cadastro";
    }

    @PostMapping("/")
    public String cadastrarUsuario(Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:/"; // Redireciona para a página de listagem após o cadastro
    }

    @GetMapping("/lista")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listarTodos();
        model.addAttribute("usuarios", usuarios);
        return "lista";
    }
}