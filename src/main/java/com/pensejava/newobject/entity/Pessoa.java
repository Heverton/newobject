package com.pensejava.newobject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Pessoa {
    @GeneratedValue
    public int id;
    public String nome;
    public String sobrenome;
    public Endereco endereco;
    public String telefone;
    public String nomeMae;
    public String nomePai;


    public Pessoa() {
    }

    public Pessoa(int id, String nome, String sobrenome, Endereco endereco, String telefone, String nomeMae, String nomePai) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }
}
