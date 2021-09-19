package com.arthur.dev.proj1.servicos;

import com.arthur.dev.proj1.entidades.Usuario;
import com.arthur.dev.proj1.exceptions.PersistenciaIndisponivelException;
import com.arthur.dev.proj1.persistencia.BancoDeDados;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServicoUsuario implements ServicoInterface<Usuario> {
  private BancoDeDados bancoDeDados;

  public ServicoUsuario() {
    this.bancoDeDados = BancoDeDados.getInstancia();
  }

  @Override
  public void registrar(Usuario u) throws PersistenciaIndisponivelException {
    try {
      this.bancoDeDados.getUsuariosWriter().write(u.toString().concat("\n").getBytes());
      this.bancoDeDados.getUsuariosWriter().close();
    } catch (IOException e) {
      throw new PersistenciaIndisponivelException(e);
    }
  }

  @Override
  public List<Usuario> listar() {
    BufferedReader usuariosReader = this.bancoDeDados.getUsuariosReader();
    String linha;
    List<Usuario> usuarios = new ArrayList<>();
    try {
      do {
        linha = usuariosReader.readLine();
        usuarios.add(Usuario.fromString(linha));
      } while (linha != null);
      this.bancoDeDados.getMensagensReader().close();
    } catch (IOException e) {
      throw new PersistenciaIndisponivelException(e);
    }
    return usuarios;
  }
}
