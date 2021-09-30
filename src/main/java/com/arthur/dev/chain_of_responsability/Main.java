package com.arthur.dev.chain_of_responsability;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

  private enum Options {
    S,
    F
  }

  public static void main(String[] args) {
    Options op;
    String param;

    try {
      op = Options.valueOf(args[0]);
      param = args[1];
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid option. Valid options are: \"S\" and \"F\"", e);
    }

    String text = "";

    switch (op) {
      case F:
        try {
          BufferedReader reader = new BufferedReader(new FileReader(param));
          StringBuilder builder = new StringBuilder();
          reader.lines().forEach(builder::append);
          text = builder.toString();
        } catch (FileNotFoundException e) {
          throw new RuntimeException("Invalid file path: " + param, e);
        }
        break;
      case S:
        text = param;
        break;
    }


    StringAnalyzer analyzer = new StringAnalyzer();

    System.out.println("Analyzing: " + text);
    analyzer.analyze(text);
  }
}
