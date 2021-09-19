package com.arthur.dev.proj1.enums;

import com.arthur.dev.proj1.exceptions.ComandoInvalidoException;

import java.util.Arrays;

public enum Comandos {
  msg,
  del,
  add;

  public static Comandos getEnum(String str) throws ComandoInvalidoException {
    return Arrays.stream(Comandos.values()).filter(c -> c.toString().equals(str))
            .findFirst()
            .orElseThrow(ComandoInvalidoException::new);
  }
}
