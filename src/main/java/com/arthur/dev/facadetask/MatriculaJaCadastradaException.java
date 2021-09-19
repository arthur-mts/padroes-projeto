package com.arthur.dev.facadetask;

public class MatriculaJaCadastradaException extends Exception {
    public MatriculaJaCadastradaException(String codAluno) {
        super("O aluno com a matricula " + codAluno + " já está cadastrado.");
    }
}
