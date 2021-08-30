package com.arthur.dev.bridgetask.janelas;

class JanelaDefault implements JanelaIMP {
    private final String SO;

    public JanelaDefault(String SO) {
        this.SO = SO;
    }

    @Override
    public void desenharJanela(String titulo) {
        System.out.printf("*** %s ***\nJanela: %s%n", this.SO, titulo);
    }

    @Override
    public void desenharBotao(String titulo) {
        System.out.printf("*** %s ***\nBotão: %s%n", this.SO, titulo);
    }
}
