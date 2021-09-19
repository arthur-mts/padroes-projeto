package com.arthur.dev.servicos;

import com.arthur.dev.exceptions.PersistenciaIndisponivelException;

import java.util.List;

public interface ServicoInterface<T> {
  void registrar(T obj) throws PersistenciaIndisponivelException;

  List<T> listar() throws PersistenciaIndisponivelException;

  void remover(String chave) throws PersistenciaIndisponivelException;
}
