package com.xpe.spring1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + id));

    user.setName(userDetails.getName());
    user.setEmail(userDetails.getEmail());
    user.setPassword(userDetails.getPassword());
    User updatedUser = userRepository.save(user);
    return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
  }

  @GetMapping
  public ResponseEntity<ArrayList<User>> getAllUsers() {
    List<User> users = userRepository.findAll();
    ArrayList<User> usersList = new ArrayList<>(users);
    return ResponseEntity.status(HttpStatus.OK).body(usersList);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userRepository.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
