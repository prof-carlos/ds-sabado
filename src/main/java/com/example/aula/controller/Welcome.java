package com.example.aula.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @GetMapping
    public String mensagem() {
        return "Bem-vindo!";
    }
}
