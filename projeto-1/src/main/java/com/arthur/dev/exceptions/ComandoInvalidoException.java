package com.arthur.dev.exceptions;

public class ComandoInvalidoException extends RuntimeException {
  private static final String MENSAGEM_BASE = "Comando invalido!";
  public ComandoInvalidoException() {
    super(MENSAGEM_BASE + " Os comandos são: add, del e msg");
  }

  public ComandoInvalidoException(String mensagem) {
    super(MENSAGEM_BASE + mensagem);
  }
}
