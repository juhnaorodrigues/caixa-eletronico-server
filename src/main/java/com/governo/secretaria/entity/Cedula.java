package com.governo.secretaria.entity;

import javax.persistence.*;

/**
 * Created by Juhnao on 1/11/18.
 */
@Entity
@Table(name = "Cedula")
public class Cedula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cedu_id", nullable = false, updatable = false)
    private int id;

    @Column(name = "cedu_valor", nullable = false, updatable = false)
    private int valor;

    @Column(name = "cedu_quantidade", nullable = false)
    private int quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
