package com.arthur.dev.proj1.servicos;

import com.arthur.dev.proj1.entidades.Usuario;
import com.arthur.dev.proj1.exceptions.PersistenciaIndisponivelException;
import com.arthur.dev.proj1.persistencia.BancoDeDados;

import java.io.IOException;
import java.util.List;

public class ServicoUsuario implements ServicoInterface<Usuario> {
    private BancoDeDados bancoDeDados;

    public ServicoUsuario() {
        this.bancoDeDados = BancoDeDados.getInstancia();
    }

    @Override
    public void registrar(Usuario u) throws PersistenciaIndisponivelException {
        try {
            this.bancoDeDados.getUsuariosWriter().write(u.toString().concat("\n"));
        } catch (IOException e) {
            throw new PersistenciaIndisponivelException(e);
        }
    }

    @Override
    public List listar() {
        return null;
    }
}
