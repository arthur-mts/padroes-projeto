package com.arthur.dev.persistencia;


import com.arthur.dev.exceptions.PersistenciaIndisponivelException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BancoDeDados {

  private static final String NOME_ARQUIVO_USUARIOS = "usuarios.txt";

  private static final String NOME_ARQUIVO_MENSAGENS = "mensagens.txt";
  private static BancoDeDados instancia;
  private final Path CAMINHO = Paths.get("src","main","resources");

  private final File arquivoMensagens = CAMINHO.resolve(NOME_ARQUIVO_MENSAGENS).toAbsolutePath().toFile();
  private final File arquivoUsuarios = CAMINHO.resolve(NOME_ARQUIVO_USUARIOS).toAbsolutePath().toFile();

  private BancoDeDados() {
    try {
      arquivoUsuarios.createNewFile();
      arquivoMensagens.createNewFile();
    } catch (IOException e) {
      System.out.println(arquivoMensagens);
      System.out.println(arquivoUsuarios);
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
    try {
      return new FileOutputStream(arquivoUsuarios, true);
    }
    catch (IOException e){
      throw new PersistenciaIndisponivelException(e);
    }
  }

  public FileOutputStream getMensagensWriter()  {
    try {
      return new FileOutputStream(arquivoMensagens, true);
    }
    catch (IOException e){
      throw new PersistenciaIndisponivelException(e);
    }
  }

  public BufferedReader getUsuariosReader() {
    try {
      return new BufferedReader(new FileReader(arquivoUsuarios));
    }
    catch (IOException e){
      throw new PersistenciaIndisponivelException(e);
    }
  }

  public BufferedReader getMensagensReader() {
    try {
      return new BufferedReader(new FileReader(arquivoMensagens));
    }
    catch (IOException e){
      throw new PersistenciaIndisponivelException(e);
    }
  }
}
