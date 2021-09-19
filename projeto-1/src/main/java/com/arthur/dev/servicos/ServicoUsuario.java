package com.arthur.dev.servicos;


import com.arthur.dev.entidades.Usuario;
import com.arthur.dev.exceptions.PersistenciaIndisponivelException;
import com.arthur.dev.exceptions.UsuarioJaExistenteException;
import com.arthur.dev.persistencia.BancoDeDados;

import java.io.BufferedReader;
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
      usuarios.stream().filter(usuarioC -> usuarioC.getApelido().equals(usuario.getApelido())).findFirst().map((__)->{
        throw new UsuarioJaExistenteException(usuario.getApelido());
      });
      this.bancoDeDados.getUsuariosWriter().write(usuario.toString().concat("\n").getBytes());
      this.bancoDeDados.getUsuariosWriter().close();
    } catch (IOException e) {
      throw new PersistenciaIndisponivelException(e);
    }
  }

  @Override
  public List<Usuario> listar() {
    BufferedReader usuariosReader = this.bancoDeDados.getUsuariosReader();
    Stream<String> linhas = usuariosReader.lines();
    return linhas.map((Usuario::fromString)).collect(Collectors.toList());
  }
}
