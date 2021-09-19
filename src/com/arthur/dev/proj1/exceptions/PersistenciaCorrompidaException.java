package com.arthur.dev.proj1.exceptions;

public class PersistenciaCorrompidaException extends RuntimeException{
  public PersistenciaCorrompidaException(Throwable e) {
    super("Falha ao ler arquivos.", e);
  }
}
