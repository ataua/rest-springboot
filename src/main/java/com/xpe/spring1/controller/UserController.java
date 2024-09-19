package com.xpe.spring1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpe.spring1.model.User;
import com.xpe.spring1.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired // injeção de dependência, faz a conexão com o banco de dados
  private UserRepository userRepository;

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User savedUser = userRepository.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
  }
}
