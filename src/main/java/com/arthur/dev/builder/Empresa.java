package com.arthur.dev.builder;

public class Empresa {
  private String nomeFantasia;
  private Pessoa dono;

  public Empresa(String nomeFantasia, Pessoa dono) {
    this.nomeFantasia = nomeFantasia;
    this.dono = dono;
  }

  public String getNomeFantasia() {
    return nomeFantasia;
  }

  public void setNomeFantasia(String nomeFantasia) {
    this.nomeFantasia = nomeFantasia;
  }

  public Pessoa getDono() {
    return dono;
  }

  public void setDono(Pessoa dono) {
    this.dono = dono;
  }

  @Override
  public String toString() {
    return "Empresa{" +
            "nomeFantasia='" + nomeFantasia + '\'' +
            ", dono=" + dono +
            '}';
  }
}
