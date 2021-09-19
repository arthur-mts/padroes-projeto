package com.arthur.dev.facadetask;

public class AlunoNaoEncontradoException extends Exception {
    public AlunoNaoEncontradoException(String codAluno) {
        super("O aluno com a matricula " + codAluno + " não foi encontrado.");
    }
}
