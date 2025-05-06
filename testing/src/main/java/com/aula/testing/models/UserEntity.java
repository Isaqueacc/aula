package com.aula.testing.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false) // não pode ser nulo
    private String nome;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail deve ser válido")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 7, message = "A senha deve ter no minimo 7 caracteres")
    @Column(nullable = false)
    private String senha;

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
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
