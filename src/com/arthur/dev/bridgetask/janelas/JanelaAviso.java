package com.arthur.dev.bridgetask.janelas;

public class JanelaAviso extends JanelaAbstrata {

    public JanelaAviso(JanelaIMP j) {
        super(j);
    }

    @Override
    public void desenhar() {
        desenharJanela("Janela de Aviso");
        desenharBotao("Ok");
    }

}

