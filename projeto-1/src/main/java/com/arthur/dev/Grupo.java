package com.arthur.dev;


import com.arthur.dev.entidades.Mensagem;
import com.arthur.dev.entidades.Usuario;
import com.arthur.dev.enums.Comandos;
import com.arthur.dev.exceptions.ComandoInvalidoException;
import com.arthur.dev.exceptions.UsuarioNaoEncontradoException;
import com.arthur.dev.servicos.ServicoInterface;
import com.arthur.dev.servicos.ServicoUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Grupo {
  private List<Usuario> usuarios;

  private List<Mensagem> mensagens;

  private ServicoInterface<Usuario> servicoUsuario;

  private ServicoInterface<Mensagem> servicoMensagem;

  public Grupo() {
    this.servicoUsuario = new ServicoUsuario();
    this.usuarios = this.servicoUsuario.listar();
    this.mensagens = new ArrayList<>();
  }

  public void adicionarUsuario(String nome) {
    Usuario user = new Usuario(nome);
    servicoUsuario.registrar(user);
    this.usuarios = servicoUsuario.listar();
    System.out.printf("\"%s\" entrou no grupo\n", nome);
  }

  public void removerUsuario(String nome) {
    this.servicoUsuario.remover(nome);
    this.usuarios = servicoUsuario.listar();
    System.out.printf("\"%s\" saiu do grupo\n", nome);
  }

  public void enviarMensagem(String apelidoUsuario, String mensagem) {
    Usuario usuario = this.getUsuario(apelidoUsuario);
    Mensagem novaMensagem = new Mensagem(usuario, mensagem);
    this.notificarParaUsuarios(novaMensagem);
  }

  public Usuario getUsuario(String nome) {
    Optional<Usuario> user = this.usuarios.stream().filter(userC -> userC.getApelido().equals(nome)).findFirst();
    return user.orElseThrow(() -> new UsuarioNaoEncontradoException(nome));
  }

  private void notificarParaUsuarios(Mensagem mensagem) {
    this.usuarios.forEach(usuario -> {
      if (!usuario.equals(mensagem.getDono())) {
        usuario.receberMensagem(mensagem);
      }
    });
  }


  public static void main(String[] args) {
    if (args.length == 0) throw new ComandoInvalidoException();
    Comandos comando = Comandos.getEnum(args[0]);

    Grupo g = new Grupo();

    String apelido;
    String mensagem;

    switch (comando) {
      case add:
        if (args.length < 2)
          throw new ComandoInvalidoException("Digite o apelido do usuário.");
        apelido = args[1];
        g.adicionarUsuario(apelido);
        break;
      case del:
        if (args.length < 2)
          throw new ComandoInvalidoException("Digite o apelido do usuário.");
        apelido = args[1];
        g.removerUsuario(apelido);
        break;
      case msg:
        if (args.length < 2)
          throw new ComandoInvalidoException("Digite o apelido do usuario e em seguida sua mensagem.");
        apelido = args[1];
        mensagem = args[2];
        g.enviarMensagem(apelido, mensagem);
        break;
    }
  }
}
