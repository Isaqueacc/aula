package com.aula.testing.service;

import com.aula.testing.models.UserEntity;
import com.aula.testing.repository.UserRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepo userRepo;

    // Lista todos os usuarios do sistema
    public List<UserEntity> ListAll(){
        return userRepo.findAll();
    }

    // Cria novos usuarios
    public UserEntity Save(@Valid UserEntity userEntity){
        if (userRepo.findByEmail(userEntity.getEmail()).isPresent()){
            throw new IllegalArgumentException("Usuario já cadastrado");
        }
        return userRepo.save(userEntity);
    }

    // Atualizar usuario
    public ResponseEntity<UserEntity> atualizar(@PathVariable long id, @RequestBody UserEntity userEntity){
        UserEntity userNow = userRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Usuario não cadastrado : " + id));
        userNow.setNome(userEntity.getNome());
        userNow.setEmail(userEntity.getEmail());
        userNow.setSenha(userEntity.getSenha());
        userRepo.save(userNow);
        return ResponseEntity.ok(userNow);
    }

    //Excluir usuario
    public void excluir(Long id){
        UserEntity userTrash = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
        userRepo.deleteById(userTrash.getId());
    }

}
