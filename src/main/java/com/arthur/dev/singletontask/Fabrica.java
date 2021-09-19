package com.arthur.dev.singletontask;

import java.util.Scanner;

public class Fabrica {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Digite um número inteiro:");
        int n = scanner.nextInt();

        Highlander h;
        for (int i = 0; i < n; i++) {
            h = Highlander.obterInstancia();
        }

        System.out.printf("Foi tentado instanciar a classe Highlander %d vezes.", Highlander.getTentativasDeInstanicia());
    }
}

