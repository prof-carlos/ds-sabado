package com.senai.projeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Welcome {

    @GetMapping
    public String welcome(){
        return "Bem-vindo ao projeto.";
    }

    @GetMapping("/dev")
    public String dev(){
        return "Desenvolvido por: Carlos Anderson";
    }
}
