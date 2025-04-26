package com.aula.testing.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity // Sinalizar tabela
@Table(name = "TabUser") // Nome da tabela
public class UserEntity {

    @Id// Sinalizar que é um Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gerar numero Id
    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false) // não pode ser nulo
    private String nome;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail deve ser valido")
    @Column(nullable = false)
    private String email;
    @NotBlank(message = "Senha é obrigatório")
    @Size(min = 6 , message = "A senha deve ter no minimo 3 caracteres")
    @Column(nullable = false)
    private String Senha;
    //ORM

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

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public UserEntity(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.Senha = senha;
    }
}
