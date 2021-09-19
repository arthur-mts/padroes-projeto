package com.arthur.dev.servicos;


import com.arthur.dev.entidades.Usuario;
import com.arthur.dev.exceptions.PersistenciaIndisponivelException;
import com.arthur.dev.exceptions.UsuarioJaExistenteException;
import com.arthur.dev.exceptions.UsuarioNaoEncontradoException;
import com.arthur.dev.persistencia.BancoDeDados;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServicoUsuario implements ServicoInterface<Usuario> {
  private BancoDeDados bancoDeDados;

  public ServicoUsuario() {
    this.bancoDeDados = BancoDeDados.getInstancia();
  }

  @Override
  public void registrar(Usuario usuario) throws PersistenciaIndisponivelException {
    try {
      List<Usuario> usuarios = this.listar();
      FileOutputStream usuariosWriter = this.bancoDeDados.getUsuariosWriter();
      usuarios.stream().filter(usuarioC -> usuarioC.getApelido().equals(usuario.getApelido())).findFirst().map((__) -> {
        throw new UsuarioJaExistenteException(usuario.getApelido());
      });
      usuariosWriter.write(usuario.toString().concat("\n").getBytes());
      usuariosWriter.close();
    } catch (IOException e) {
      throw new PersistenciaIndisponivelException(e);
    }
  }

  @Override
  public List<Usuario> listar() {
    try {
      BufferedReader usuariosReader = this.bancoDeDados.getUsuariosReader();
      Stream<String> linhas = usuariosReader.lines();
      List<Usuario> usuarios = linhas.map((Usuario::fromString)).collect(Collectors.toList());
      usuariosReader.close();
      return usuarios;
    } catch (IOException e) {
      throw new PersistenciaIndisponivelException(e);
    }
  }

  @Override
  public void remover(String chave) {
    try {
      BufferedReader usuariosReader = this.bancoDeDados.getUsuariosReader();
      StringBuilder conteudoBuilder = new StringBuilder();
      usuariosReader.lines().forEach((linha)-> conteudoBuilder.append(linha.concat("\n")));

      StringBuilder novoConteudoBuilder = new StringBuilder();
      String[] strings = conteudoBuilder.toString().split("\n");

      if(conteudoBuilder.toString().isBlank())
        throw new UsuarioNaoEncontradoException(chave);

      for (String i : strings) {
        Usuario uc = Usuario.fromString(i);
        if (!uc.getApelido().equals(chave)) {
          novoConteudoBuilder.append(i.concat("\n"));
        }
      }

      if(novoConteudoBuilder.toString().length() == conteudoBuilder.toString().length())
        throw new UsuarioNaoEncontradoException(chave);

      this.bancoDeDados.deleteUsuariosFile();

      FileOutputStream usuariosWriter = this.bancoDeDados.getUsuariosWriter();

      usuariosWriter.write(novoConteudoBuilder.toString().getBytes());
      usuariosWriter.close();

    } catch (IOException e) {
      throw new PersistenciaIndisponivelException(e);
    }
  }
}
