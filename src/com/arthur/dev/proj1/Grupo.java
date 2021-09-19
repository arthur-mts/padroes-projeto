package com.arthur.dev.proj1;

import com.arthur.dev.proj1.entidades.Mensagem;
import com.arthur.dev.proj1.entidades.Usuario;
import com.arthur.dev.proj1.enums.Comandos;
import com.arthur.dev.proj1.exceptions.ComandoInvalidoException;
import com.arthur.dev.proj1.exceptions.UsuarioNaoEncontradoException;
import com.arthur.dev.proj1.persistencia.BancoDeDados;
import com.arthur.dev.proj1.servicos.ServicoInterface;
import com.arthur.dev.proj1.servicos.ServicoUsuario;

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
    System.out.printf("Usuário \"%s\" adicionado com sucesso!\n", nome);
  }

  public void removerUsuario(String nome) {
    this.usuarios.remove(this.getUsuario(nome));
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
    this.usuarios.forEach(usuario -> usuario.receberMensagem(mensagem));
  }


  public static void main(String[] args) {
    Comandos comando = Comandos.getEnum(args[0]);

    Grupo g = new Grupo();

    String apelido;
    String mensagem;

    switch (comando) {
      case add:
        if(args.length < 2)
          throw new ComandoInvalidoException("Digite o apelido do usuário.");
        apelido = args[1];
        g.adicionarUsuario(apelido);
        break;
      case del:
        if(args.length < 2)
          throw new ComandoInvalidoException("Digite o apelido do usuário.");
        apelido = args[1];
        g.removerUsuario(apelido);
        break;
      case msg:
        if(args.length < 2)
          throw new ComandoInvalidoException("Digite o apelido do usuario e em seguida sua mensagem.");
        apelido = args[1];
        mensagem = args[2];
        g.enviarMensagem(apelido, mensagem);
        break;
    }
  }
}
