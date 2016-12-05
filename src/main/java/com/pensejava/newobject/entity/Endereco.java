package com.pensejava.newobject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * Created by heverton.cruz on 05/12/2016.
 */
@Entity
public class Endereco {
    @GeneratedValue
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
