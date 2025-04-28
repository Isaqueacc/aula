package com.aula.testing.controller;

import com.aula.testing.models.UserEntity;
import com.aula.testing.repository.UserRepo;
import com.aula.testing.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationNotFoundException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> ListarTodos(){
        return userService.ListAll();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> save(@RequestBody UserEntity user) {
        userService.Save(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("Mensagem", "Usuario cadastrado com sucesso"));

    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody UserEntity user) {
        userService.atualizar(user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Usuario Atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable Long id) {
        userService.excluir(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Usuario excluido com sucesso"));
    }
}
