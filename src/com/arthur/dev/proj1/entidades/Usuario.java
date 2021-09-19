package com.arthur.dev.proj1.entidades;

import com.arthur.dev.proj1.exceptions.PersistenciaIndisponivelException;

public class Usuario {
  private String apelido;

  public Usuario(String apelido) {
    this.apelido = apelido;
  }

  public String getApelido() {
    return apelido;
  }

  public void setApelido(String apelido) {
    this.apelido = apelido;
  }

  public void receberMensagem(Mensagem m) {
    System.out.printf("Mensagem de %s: %s%n", m.getDono().getApelido(), m.getConteudo());
  }

  @Override
  public String toString() {
    return String.format("Usuario:%s", apelido);
  }

  public static Usuario fromString(String str) {
    try {
      String[] strings = str.split(":");
      return new Usuario(strings[1]);
    } catch (Throwable e) {
      throw new PersistenciaIndisponivelException(e);
    }
  }
}
