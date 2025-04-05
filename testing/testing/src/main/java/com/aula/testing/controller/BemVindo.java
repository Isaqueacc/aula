package com.aula.testing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class BemVindo {
    @GetMapping
    public String BemVindo(){
        return "Olá";
    }

    @GetMapping("/crs")
    public String Poweread(){
        return "Origin by Isaque";

    }
}
