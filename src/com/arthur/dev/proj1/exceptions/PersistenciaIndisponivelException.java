package com.arthur.dev.proj1.exceptions;

public class PersistenciaIndisponivelException extends RuntimeException {

  public PersistenciaIndisponivelException() {
    super("Não foi possível se conectar ao sistema de arquivos.");
  }

  public PersistenciaIndisponivelException(Throwable cause) {
    super("Não foi possível se conectar ao sistema de arquivos.", cause);
  }
}
