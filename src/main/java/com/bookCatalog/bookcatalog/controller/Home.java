package com.bookCatalog.bookcatalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/")
    public String helloWorld() {
        return "Olá Mundo";
    }
}
