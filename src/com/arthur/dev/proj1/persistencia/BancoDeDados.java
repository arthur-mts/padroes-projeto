package com.arthur.dev.proj1.persistencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BancoDeDados {

    private static final String ARQUIVO_USUARIOS = "./persistencia/usuarios.txt";

    private static final String ARQUIVO_MENSAGENS = "mensagens.txt";

    private final Path CAMINHO = Paths.get("persistencia", "recursos");

    private static BancoDeDados instancia;

    private BufferedWriter usuariosWriter;

    private BufferedWriter mensagensWriter;

    public BufferedWriter getUsuariosWriter() {
        return usuariosWriter;
    }

    public BufferedWriter getMensagensWriter() {
        return mensagensWriter;
    }

    public static BancoDeDados getInstancia() {
        if(instancia == null) {
            instancia = new BancoDeDados();
        }
        return instancia;
    }

    private BancoDeDados() {
        try {
            this.usuariosWriter = new BufferedWriter(new FileWriter(CAMINHO.resolve(ARQUIVO_MENSAGENS).toFile()));
            this.mensagensWriter = new BufferedWriter(new FileWriter(CAMINHO.resolve(ARQUIVO_MENSAGENS).toFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
