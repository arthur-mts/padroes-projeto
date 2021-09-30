package com.arthur.dev.chain_of_responsability;

public class PointerHandler extends Handler {
  @Override
  public void checkCharacter(char c) {
    if (c == '.') {
      this.increaseCounter();
      return;
    }
    this.checkNext(c);
  }

  @Override
  public void displayResult() {
    System.out.printf("Points: %d\n", this.getCounter());
  }
}
