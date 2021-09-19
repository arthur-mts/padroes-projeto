package com.arthur.dev.exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {
  public UsuarioNaoEncontradoException(String nomeUsuario) {
    super(String.format("O usuário %s não foi encontrado", nomeUsuario));
  }
}
