package sequential;

import utils.ConstantsUtils;
import utils.RollDiceUtils;

public class SequentialMain {

  private static final long FIVE_HUNDRED_MILLISECONDS = 500L;

  public static void main(String[] args) {
    System.out.println("Starting the sequential test.");

    RollDiceUtils rollDiceUtils = new RollDiceUtils();
    rollDiceUtils.rollDice(Thread.currentThread().getName(), FIVE_HUNDRED_MILLISECONDS, ConstantsUtils.NUMBER_OF_EXECUTIONS);

    System.out.println("Finishing the sequential test.");
  }
}
