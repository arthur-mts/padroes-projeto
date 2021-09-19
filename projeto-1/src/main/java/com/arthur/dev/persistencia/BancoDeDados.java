package com.arthur.dev.persistencia;


import com.arthur.dev.exceptions.PersistenciaIndisponivelException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BancoDeDados {

  private static final String NOME_ARQUIVO_USUARIOS = "usuarios.txt";

  private static BancoDeDados instancia;
  private final Path CAMINHO = Paths.get("resources");

  private final File arquivoUsuarios = CAMINHO.resolve(NOME_ARQUIVO_USUARIOS).toAbsolutePath().toFile();

  private BancoDeDados() {
    try {
      if(!arquivoUsuarios.exists()){
        Files.createDirectories(CAMINHO.getFileName());
      }
      arquivoUsuarios.createNewFile();
    } catch (IOException e) {
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

  public BufferedReader getUsuariosReader() {
    try {
      return new BufferedReader(new FileReader(arquivoUsuarios));
    }
    catch (IOException e){
      throw new PersistenciaIndisponivelException(e);
    }
  }

  public FileOutputStream getUsuariosWriter() {
    try {
      return new FileOutputStream(arquivoUsuarios, true);
    }
    catch (IOException e){
      throw new PersistenciaIndisponivelException(e);
    }
  }

  public void deleteUsuariosFile() {
    if(!this.arquivoUsuarios.delete()){
      throw new PersistenciaIndisponivelException();
    }
  }
}
