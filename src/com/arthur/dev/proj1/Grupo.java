package com.arthur.dev.proj1;

import com.arthur.dev.proj1.entidades.Mensagem;
import com.arthur.dev.proj1.entidades.Usuario;
import com.arthur.dev.proj1.exceptions.UsuarioNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Grupo {
    private List<Usuario> usuarios;

    private List<Mensagem> mensagens;

    public Grupo() {
        this.usuarios = new ArrayList<>();
        this.mensagens = new ArrayList<>();
    }

    public void adicionarUsuario(String nome) {
        Usuario user = new Usuario(nome);
        this.usuarios.add(user);
    }
    
    public void removerUsuario(String nome) throws UsuarioNaoEncontradoException {
        Optional<Usuario> user = this.usuarios.stream().filter(userC -> userC.getNome().equals(nome)).findFirst();

        user.map(this.usuarios::remove)
            .orElseThrow(()->new UsuarioNaoEncontradoException(nome));
    }

    public void enviarMensagem(Usuario u, String mensagem) {
        Mensagem novaMensagem = new Mensagem(u, mensagem);
    }
}
