package com.arthur.dev.chain_of_responsability;

public class BlankSpaceHandler extends Handler {
  @Override
  public void checkCharacter(char c) {
    if(Character.isWhitespace(c)){
      this.increaseCounter();
      return;
    }
    this.checkNext(c);
  }

  @Override
  public void displayResult() {
    System.out.printf("Blank spaces: %d\n", this.getCounter());
  }
}
