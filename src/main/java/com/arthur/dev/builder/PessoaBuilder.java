package com.arthur.dev.builder;

public class PessoaBuilder implements Builder<Pessoa>{

  private String nome;
  private String identidade;

  private void limpar() {
    this.setNome(null);
    this.setIdentidade(null);
  }

  @Override
  public Pessoa getResultado() {
    return new Pessoa(this.getNome(), this.getIdentidade());
  }

  public String getNome() {
    return nome;
  }

  public PessoaBuilder setNome(String nome) {
    this.nome = nome;
    return this;
  }

  public String getIdentidade() {
    return identidade;
  }

  public PessoaBuilder setIdentidade(String identidade) {
    this.identidade = identidade;
    return this;
  }
}
