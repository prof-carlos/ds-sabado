package com.example.aula.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    // Formata as mensagens de erro se o usuário já está cadastrado no banco de dados.
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> illegalArgumentException(IllegalArgumentException erro) {
        return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of(
                        "mensagem", erro.getMessage(),
                        "sucesso", false
                    ));
    }
    
    // Formata as mensagens de erro dos dados enviados pelo usuário no RequestDTO.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> methodArgumentNotValidException(MethodArgumentNotValidException erro) {
        return ResponseEntity
                    .badRequest()
                    .body(Map.of(
                        "mensagem", erro.getFieldErrors().get(0).getDefaultMessage(),
                        "sucesso", false
                    ));
    }

    // Formata as mensagens de erro nas exceções do CRUD no Service.
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> runtimeException(RuntimeException erro) {
        return ResponseEntity
                    .badRequest()
                    .body(Map.of(
                        "mensagem", erro.getMessage(),
                        "sucesso", false
                    ));
    }
}
            