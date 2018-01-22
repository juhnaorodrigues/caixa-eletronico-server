package com.governo.secretaria.entity;

import javax.persistence.*;

/**
 * Created by Juhnao on 1/16/18.
 */
@Entity
@SequenceGenerator(name="SEQ_PESSOA_ID", sequenceName="SEQ_PESSOA_ID")
public class Pessoa {

    @Id
    @Column(name = "pess_id", unique = true, nullable = false)
    private long id;

    @Column(name = "pess_login", unique = true, nullable = false, length = 50)
    private String login;

    @Column(name = "pess_nome", unique = true, nullable = false, length = 200)
    private String nome;

    @Column(name = "pess_senha", unique = true, nullable = false, length = 50)
    private String senha;

    @Column(name = "pess_role", unique = true, nullable = false, length = 10)
    private String role;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}