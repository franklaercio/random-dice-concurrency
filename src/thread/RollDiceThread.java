package thread;

import utils.RollDiceUtils;

public class RollDiceThread extends Thread {

  private final int numberOfTimes;
  private final long timeSleep;

  public RollDiceThread(String name, int numberOfTimes, long timeSleep) {
    super(name);
    this.numberOfTimes = numberOfTimes;
    this.timeSleep = timeSleep;
  }

  @Override
  public void run() {
    RollDiceUtils rollDiceUtils = new RollDiceUtils();
    rollDiceUtils.rollDice(this.getName(), timeSleep, numberOfTimes);
  }
}