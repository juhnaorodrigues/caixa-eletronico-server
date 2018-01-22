package com.governo.secretaria.entity.request;

/**
 * Created by Juhnao on 1/16/18.
 */
public class PessoaRequest {

    public PessoaRequest() {
    }

    private String nome;

    private int id;

    private String senha;

    private String login;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
