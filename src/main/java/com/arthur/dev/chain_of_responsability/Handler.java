package com.arthur.dev.chain_of_responsability;

public abstract class Handler {
  private Handler next;
  private Integer counter;

  protected void increaseCounter(){
    this.counter++;
  }

  public Integer getCounter(){
    return this.counter;
  }

  public Handler() {
    this.counter = 0;
  }

  public abstract void checkCharacter(char c);

  public Handler getNext() {
    return next;
  }

  public void displayResult() {
    System.out.printf("Counter = %d\n", this.getCounter());
  }

  public void clearResults() {
    this.counter = 0;
  }

  public Handler attachNext(Handler next) {
    this.next = next;
    return next;
  }

  protected void checkNext(char c) {
    if(next == null) {
      return;
    }
    this.next.checkCharacter(c);
  }

}
