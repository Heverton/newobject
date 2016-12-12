package com.pensejava.newobject.entity;

public class Pessoa {
    private int id;
    private String nome;
    private String sobrenome;
    private Endereco enderecos;
    private String telefone;
    private String nomeMae;
    private String nomePai;


    public Pessoa() {
    }

    public Pessoa(int id, String nome, String sobrenome, Endereco enderecos, String telefone, String nomeMae, String nomePai) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.enderecos = enderecos;
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

    public Endereco getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco enderecos) {
        this.enderecos = enderecos;
    }
}
