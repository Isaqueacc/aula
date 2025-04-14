package com.aula.testing.controller;

import com.aula.testing.models.ProductEntity;
import com.aula.testing.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }
    @GetMapping
    public List<ProductEntity> ListAll(){
        return productRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<ProductEntity> save(@RequestBody ProductEntity product){
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping
    public ResponseEntity<ProductEntity> Load(@RequestBody ProductEntity product){
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
