package com.arthur.dev.exceptions;

public class UsuarioJaExistenteException extends RuntimeException {
  public UsuarioJaExistenteException(String apelido) {
    super(String.format("O usuário \"%s\" já existe", apelido));
  }
}
