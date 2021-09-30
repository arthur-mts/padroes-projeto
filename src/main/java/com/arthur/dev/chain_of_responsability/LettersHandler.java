package com.arthur.dev.chain_of_responsability;

public class LettersHandler extends Handler {
  @Override
  public void checkCharacter(char c) {
    if (Character.isLetter(c)) {
      this.increaseCounter();
      return;
    }
    this.checkNext(c);
  }

  @Override
  public void displayResult() {
    System.out.printf("Letters: %d\n", this.getCounter());
  }
}
