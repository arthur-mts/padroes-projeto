package com.arthur.dev.chain_of_responsability;

public class StringAnalyzer {

  private final Handler handler;

  public StringAnalyzer() {
    this.handler = new NumbersHandler();
    this.handler.attachNext(new BlankSpaceHandler()).attachNext(new LettersHandler()).attachNext(new PointerHandler());
  }

  public Handler getHandler() {
    return handler;
  }

  public void analyze(String text) {
    for (char c: text.toCharArray()) {
      this.analyzeChar(c);
    }
    this.displayResults();
    this.clearHandlerResults();
  }

  private void analyzeChar(char c) {
    this.getHandler().checkCharacter(c);
  }

  public void displayResults() {
    Handler current = this.getHandler();
    do {
      current.displayResult();
      current = current.getNext();
    } while (current != null);
  }

  private void clearHandlerResults() {
    Handler current = this.getHandler();
    do {
      current.clearResults();
      current = current.getNext();
    } while (current != null);
  }
}
