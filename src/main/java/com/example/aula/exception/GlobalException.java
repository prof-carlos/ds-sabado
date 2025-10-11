package com.example.aula.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Captura todas as exceções lançadas pela API.
// Mostra apenas as mensagens no padrão: {chave : valor}

@RestControllerAdvice
public class GlobalException {

    // Formata as mensagens das exceções do tipo: IllegalArgumentException.
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> illegalArgumentException(IllegalArgumentException erro) {
        
        return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("mensagem", erro.getMessage()));     
    }

    // Formata as mensagens das exceções do tipo: RuntimeException.
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> runtimeException(RuntimeException erro) {
        
        return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("mensagem", erro.getMessage()));     
    }

    // Captura todas as exceções não mapeadas e retorna uma mensagem genérica
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleAllExceptions(Exception erro) {
        return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("mensagem", "Erro no servidor"));
    }
}
