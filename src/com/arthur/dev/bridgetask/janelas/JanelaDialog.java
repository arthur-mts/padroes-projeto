package com.arthur.dev.bridgetask.janelas;

public class JanelaDialog extends JanelaAbstrata{
    public JanelaDialog(JanelaIMP janela) {
        super(janela);
    }

    @Override
    public void desenhar() {
        desenharJanela("Janela de Diálogo");
        desenharBotao("Botão Sim");
        desenharBotao("Botão Não");
        desenharBotao("Botão Cancelar");
    }
}
