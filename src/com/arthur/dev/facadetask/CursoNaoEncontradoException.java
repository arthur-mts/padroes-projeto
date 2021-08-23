package com.arthur.dev.facadetask;

public class CursoNaoEncontradoException extends Exception{
    public CursoNaoEncontradoException(String codCurso) {
        super("Curso com o código " + codCurso + " não encontrado.");
    }
}
