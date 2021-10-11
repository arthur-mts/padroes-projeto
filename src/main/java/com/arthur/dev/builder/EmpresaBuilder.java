package com.arthur.dev.builder;

public class EmpresaBuilder implements Builder<Empresa> {

  private String nomeFantasia;
  private String nomeDono;
  private String identidadeDono;
  private Pessoa pessoaDono;

  private String getNomeFantasia() {
    return nomeFantasia;
  }

  private String getNomeDono() {
    return nomeDono;
  }

  private String getIdentidadeDono() {
    return identidadeDono;
  }

  private Pessoa getPessoaDono() {
    return pessoaDono;
  }

  private void limpar() {
    this.setNomeFantasia(null);
    this.setPessoaDono(null);
    this.setIdentidadeDono(null);
    this.setNomeDono(null);
  }

  @Override
  public Empresa getResultado() {
    Empresa e;
    if (pessoaDono != null) {
      e = new Empresa(this.getNomeFantasia(), this.getPessoaDono());
    } else if (nomeDono != null && identidadeDono != null) {
      e = new Empresa(this.getNomeFantasia(), new Pessoa(this.getNomeDono(), this.getIdentidadeDono()));
    } else {
      throw new IllegalArgumentException("É preciso especificar o dono da empresa!");
    }
    limpar();
    return e;
  }

  public EmpresaBuilder setPessoaDono(Pessoa pessoaDono) {
    this.pessoaDono = pessoaDono;
    return this;
  }


  public EmpresaBuilder setNomeFantasia(String nomeFantasia) {
    this.nomeFantasia = nomeFantasia;
    return this;
  }


  public EmpresaBuilder setNomeDono(String nomeDono) {
    this.nomeDono = nomeDono;
    return this;
  }


  public EmpresaBuilder setIdentidadeDono(String identidadeDono) {
    this.identidadeDono = identidadeDono;
    return this;
  }
}
