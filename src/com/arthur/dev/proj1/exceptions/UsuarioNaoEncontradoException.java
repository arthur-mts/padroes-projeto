package com.arthur.dev.proj1.exceptions;

public class UsuarioNaoEncontradoException extends Exception{
    public UsuarioNaoEncontradoException(String nomeUsuario) {
        super(String.format("O usuário %s não foi encontrado", nomeUsuario));
    }
}
