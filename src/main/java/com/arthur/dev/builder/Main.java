package com.arthur.dev.builder;

public class Main {

  public static void main(String[] args) {
    PessoaBuilder pessoaBuilder = new PessoaBuilder();

    EmpresaBuilder empresaBuilder = new EmpresaBuilder();
    Pessoa pessoa = pessoaBuilder.setIdentidade("123").setNome("Arthur").getResultado();

    Empresa mcDonalds =  empresaBuilder.setNomeFantasia("MC Donalds").setPessoaDono(pessoa).getResultado();

    Empresa bobs = empresaBuilder.setNomeFantasia("Bobs").setNomeDono("Jose").setIdentidadeDono("1234").getResultado();

    System.out.println(mcDonalds);

    System.out.println(bobs);
  }
}
