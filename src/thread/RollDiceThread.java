package thread;

import utils.HttpRollDice;

public class RollDiceThread extends Thread {

  private final int numberOfTimes;

  public RollDiceThread(String name, int numberOfTimes) {
    super(name);
    this.numberOfTimes = numberOfTimes;
  }

  @Override
  public void run() {
    HttpRollDice httpRollDice = new HttpRollDice();
    httpRollDice.rollDice(this.getName(), numberOfTimes);
  }
}