package com.aula.testing.models;

import jakarta.persistence.*;
import lombok.*;

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
