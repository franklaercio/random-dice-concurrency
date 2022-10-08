package sequential;

import java.time.Duration;
import java.time.Instant;
import utils.ConstantsUtils;
import utils.RollDiceUtils;

public class SequentialMain {

  public static void main(String[] args) {
    Instant start = Instant.now();

    System.out.println("Starting the sequential test.");

    RollDiceUtils rollDiceUtils = new RollDiceUtils();
    rollDiceUtils.rollDice(Thread.currentThread().getName(), ConstantsUtils.INTERVAL_TIME, ConstantsUtils.NUMBER_OF_EXECUTIONS);

    Instant end = Instant.now();

    System.out.println("Finishing the " + Thread.currentThread().getName() + " with " + Duration.between(start, end).toMillis() + " ms.");

    System.out.println("Finishing the sequential test.");
  }
}
