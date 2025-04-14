package com.aula.testing.controller;

import com.aula.testing.models.UserEntity;
import com.aula.testing.repository.UserRepositoy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class UserController {
    private UserRepositoy userRepositoy;

    public UserController(UserRepositoy userRepositoy) {
        this.userRepositoy = userRepositoy;
    }

    @GetMapping
    public List<UserEntity> ListarTodos(){
        return userRepositoy.findAll();

    }
    @PostMapping
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity user) {
    userRepositoy.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
