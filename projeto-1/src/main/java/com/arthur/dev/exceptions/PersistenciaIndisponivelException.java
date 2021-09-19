package com.arthur.dev.exceptions;

public class PersistenciaIndisponivelException extends RuntimeException {

  public PersistenciaIndisponivelException() {
    super("Não foi possível se conectar ao sistema de arquivos.");
  }

  public PersistenciaIndisponivelException(Throwable cause) {
    super("Não foi possível se conectar ao sistema de arquivos.", cause);
  }
}
