package com.aula.testing.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity // Sinalizar tabela
@Table(name = "TabUser") // Nome da tabela
public class UserEntity {

    @Id// Sinalizar que é um Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gerar numero Id
    private Long id;
    @Column(nullable = false) // não pode ser nulo
    private String nome;
    @Column(nullable = false)
    private String email;
    //ORM

}
