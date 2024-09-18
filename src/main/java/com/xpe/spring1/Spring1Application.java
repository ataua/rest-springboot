package com.xpe.spring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* @SpringBootApplication - registra os controladores automaticamente, linkando as classes anotadas
* com @RestController dentro do mesmo package, por isso não precisa importar cada uma
*/ 
@SpringBootApplication 
public class Spring1Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring1Application.class, args);
	}

}
