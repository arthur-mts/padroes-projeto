package com.arthur.dev.proj1.persistencia;

import com.arthur.dev.proj1.exceptions.PersistenciaIndisponivelException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BancoDeDados {

  private static final String NOME_ARQUIVO_USUARIOS = "usuarios.txt";

  private static final String NOME_ARQUIVO_MENSAGENS = "mensagens.txt";
  private static BancoDeDados instancia;
  private final Path CAMINHO = Paths.get("persistencia", "recursos");


  private final FileOutputStream usuariosWriter;
  private final BufferedReader usuariosReader;
  private final FileOutputStream mensagensWriter;
  private final BufferedReader mensagensReader;

  private BancoDeDados() {
    try {
      File arquivoMensagens = CAMINHO.resolve(NOME_ARQUIVO_MENSAGENS).toAbsolutePath().toFile();
      File arquivoUsuarios = CAMINHO.resolve(NOME_ARQUIVO_USUARIOS).toAbsolutePath().toFile();
      arquivoUsuarios.createNewFile();
      this.usuariosWriter = new FileOutputStream(arquivoUsuarios, true);
      this.usuariosReader = new BufferedReader(new FileReader(arquivoUsuarios));
      arquivoMensagens.createNewFile();
      this.mensagensWriter = new FileOutputStream(arquivoMensagens, true);
      this.mensagensReader = new BufferedReader(new FileReader(arquivoMensagens));
    } catch (IOException e) {
      throw new PersistenciaIndisponivelException(e);
    }
  }

  public static BancoDeDados getInstancia() {
    if (instancia == null) {
      instancia = new BancoDeDados();
    }
    return instancia;
  }

  public FileOutputStream getUsuariosWriter() {
    return usuariosWriter;
  }

  public FileOutputStream getMensagensWriter() {
    return mensagensWriter;
  }

  public BufferedReader getUsuariosReader() {
    return usuariosReader;
  }

  public BufferedReader getMensagensReader() {
    return mensagensReader;
  }
}
