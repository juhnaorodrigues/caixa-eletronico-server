package com.governo.secretaria.entity;

/**
 * Created by Juhnao on 1/21/18.
 */
public class PessoaToken {
    private Pessoa pessoa;
    private String token;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
