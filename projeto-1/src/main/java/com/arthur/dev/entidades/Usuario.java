package com.arthur.dev.entidades;


import com.arthur.dev.exceptions.PersistenciaIndisponivelException;

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
    System.out.printf("[%s] Mensagem de %s: \"%s\"\n", this.getApelido(), m.getDono().getApelido(), m.getConteudo());
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
