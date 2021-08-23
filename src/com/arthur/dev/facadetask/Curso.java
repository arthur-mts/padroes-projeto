package com.arthur.dev.facadetask;

import java.nio.charset.Charset;
import java.util.Random;

public class Curso {

    private String nome;

    private String codCurso;


    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public Curso(String nome) {
        this.nome = nome;
        this.codCurso = Curso.gerarCodigoAleatorio();
    }

    private static String gerarCodigoAleatorio() {
        byte[] array = new byte[3];
        new Random().nextBytes(array);
        return new String(array, Charset.defaultCharset());
    }

    public Curso(String nome, String codCurso) {
        this.nome = nome;
        this.codCurso = codCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
