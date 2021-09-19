package com.arthur.dev.proj1.entidades;

public class Mensagem {
    private Usuario dono;
    private String conteudo;

    public Mensagem(Usuario dono, String conteudo) {
        this.dono = dono;
        this.conteudo = conteudo;
    }

    public Usuario getDono() {
        return dono;
    }

    public void setDono(Usuario dono) {
        this.dono = dono;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
