package com.arthur.dev.proj1.entidades;

public class Usuario {
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return String.format("Usuario:%s", nome);
    }
}
