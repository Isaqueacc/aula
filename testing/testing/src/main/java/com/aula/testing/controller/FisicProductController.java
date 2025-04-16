package com.aula.testing.controller;


import com.aula.testing.models.FisicProductEntity;
import com.aula.testing.repository.FisicProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/FisicProducts")
public class FisicProductController {
    private FisicProductRepo fisicProductRepo;

    @GetMapping //Retorna a lista que estão em estoque
    public List<FisicProductEntity> ListAll(){
        return fisicProductRepo.findAll();
    }

    @PostMapping //Adiciona produtos ao estoque
    public ResponseEntity<FisicProductEntity> save(@RequestBody FisicProductEntity fisicProductEntity){
        fisicProductRepo.save(fisicProductEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(fisicProductEntity);
    }
}
