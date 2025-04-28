package com.aula.testing.service;

import com.aula.testing.models.UserEntity;
import com.aula.testing.repository.UserRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo)
    {
        this.userRepo = userRepo;
    }

    public List <UserEntity> ListAll(){

        return userRepo.findAll();
    }
    public UserEntity Save(@Valid UserEntity userEntity){
        if (userRepo.findByEmail(userEntity.getEmail()).isPresent()){
            throw new IllegalArgumentException("Usuario ja cadstrado");
        }
        return userRepo.save(userEntity);
    }
    public UserEntity atualizar (@Valid UserEntity userEntity){
        UserEntity useratt = userRepo.findById(userEntity.getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));

        useratt.setNome(userEntity.getNome());
        useratt.setEmail(userEntity.getEmail());
        useratt.setSenha(userEntity.getSenha());
        return userRepo.save(useratt);
    }

    public void excluir(Long id){
        UserEntity userExc = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));

        userRepo.deleteById(userExc.getId());
    }
}
