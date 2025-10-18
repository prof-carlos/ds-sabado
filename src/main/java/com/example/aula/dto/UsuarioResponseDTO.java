package com.example.aula.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioResponseDTO {
    
    // Define os campos que serão exibidos na resposta da API.
    // Omite o id e a senha.
    
    private String nome;
    private String email;

}
