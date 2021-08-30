package com.arthur.dev.bridgetask.janelas;

public class JanelaDownload extends JanelaAbstrata{
    public JanelaDownload(JanelaIMP janela) {
        super(janela);
    }

    @Override
    public void desenhar() {
        desenharJanela("Janela de Download");
        desenharJanela("Você deseja realizar o download?");
        desenharBotao("SIM");
        desenharBotao("NAO");
    }
}
