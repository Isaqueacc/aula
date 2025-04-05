package com.aula.testing.model;

import jakarta.persistence.*;

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
    public UserEntity() {
    }

    public UserEntity(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
