package com.pensejava.newobject.entity;

/**
 * Created by heverton.cruz on 05/12/2016.
 */
public class Endereco {
    public int id;
    public String nome;

    public Endereco() {
    }

    public Endereco(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
