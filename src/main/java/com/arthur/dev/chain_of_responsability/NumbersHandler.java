package com.arthur.dev.chain_of_responsability;

public class NumbersHandler extends Handler {
  @Override
  public void checkCharacter(char c) {
    if (Character.isDigit(c)) {
      this.increaseCounter();
      return;
    }
    this.checkNext(c);
  }

  @Override
  public void displayResult() {
    System.out.printf("Numbers: %d\n", this.getCounter());
  }
}
