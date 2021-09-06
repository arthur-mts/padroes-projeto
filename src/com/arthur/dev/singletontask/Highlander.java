package com.arthur.dev.singletontask;

public class Highlander {
    private Highlander() {
    }

    private static Highlander instancia;

    private static Integer tentativasDeInstanicia = 0;

    public static Highlander obterInstancia() {
        tentativasDeInstanicia++;
        if (instancia == null)
            instancia = new Highlander();
        return instancia;
    }

    public static Integer getTentativasDeInstanicia() {
        return tentativasDeInstanicia;
    }
}
