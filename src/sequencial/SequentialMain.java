package sequencial;

import java.time.Duration;
import java.time.Instant;
import utils.HttpRollDice;
import utils.RollDiceUtil;

public class SequentialMain {

  public static void main(String[] args) {
    HttpRollDice httpRollDice = new HttpRollDice();

    System.out.println("Warm-up Java Virtual Machine...");
    httpRollDice.rollDice("MainThread", 2);

    System.out.println("Starting the sequential test...");

    Instant start = Instant.now();
    httpRollDice.rollDice("MainThread", Integer.parseInt(RollDiceUtil.NUMBER_OF_EXECUTIONS));
    Instant end = Instant.now();

    System.out.print("Finishing the main thread with a " + Duration.between(start, end).toSeconds() + "s");
  }
}
