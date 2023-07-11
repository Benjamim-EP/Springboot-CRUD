package com.devsuperior.dscatalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/categorias")
    public String helloWorld() {
        return "Olá Mundo";
    }
}
