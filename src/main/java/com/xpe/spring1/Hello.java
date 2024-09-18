package com.xpe.spring1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // indica que a classe é um controlador REST
public class Hello {

    @GetMapping("/hello") // mapeia a URL para o método hello com o verbo HTTP GET
    public String hello() {
        return "<h1>Hello World</h1>";
    }
}
