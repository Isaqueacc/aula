package com.aula.testing.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarrinhoDeComprasEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long Id;
     @OneToMany
      private List<ProductEntity> product = new ArrayList<>();
     private double total;
}
