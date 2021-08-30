package com.arthur.dev.bridgetask.janelas;

public abstract class JanelaAbstrata {
    protected JanelaIMP janela;

    public JanelaAbstrata(JanelaIMP janela) {
        this.janela = janela;
    }

    public void setJanela(JanelaIMP janela) {
        this.janela = janela;
    }

    public void desenharJanela(String titulo) {
        this.janela.desenharJanela(titulo);
    }

    public void desenharBotao(String titulo) {
        this.janela.desenharBotao(titulo);
    }

    public abstract void desenhar();
}
