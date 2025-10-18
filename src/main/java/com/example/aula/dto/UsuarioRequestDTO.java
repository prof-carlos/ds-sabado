package com.example.aula.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioRequestDTO {
    // Valida dados de entrada do usuário conforme critérios.
    
    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres.")
    private String nome;
    
    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "Deve ser um e-mail válido.")
    private String email;
    
    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 3, max = 20, message = "A senha deve ter entre 3 e 20 caracteres.")
    private String senha;

}
