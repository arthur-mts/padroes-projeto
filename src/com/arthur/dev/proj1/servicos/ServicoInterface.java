package com.arthur.dev.proj1.servicos;

import com.arthur.dev.proj1.exceptions.PersistenciaIndisponivelException;

import java.util.List;

public interface ServicoInterface<T> {
    void registrar(T obj) throws PersistenciaIndisponivelException;
    List<T> listar();
}
