package sequencial;

import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import utils.RollDiceHttpRequest;

public class SequentialMain {

  public static void main(String[] args) {
    String numberOfTimes = Objects.requireNonNull(System.getenv("NUMBER_OF_TIMES"),
        "Environment NUMBER_OF_TIMES cannot be null.");

    RollDiceHttpRequest rollDiceHttpRequest = new RollDiceHttpRequest();

    System.out.println("Warm-up Java Virtual Machine...");
    rollDice(rollDiceHttpRequest, 2);

    System.out.println("Starting the sequential test...");

    Instant start = Instant.now();
    rollDice(rollDiceHttpRequest, Integer.parseInt(numberOfTimes));
    Instant end = Instant.now();

    System.out.print("Finishing the main thread with a " + Duration.between(start, end).toSeconds() + "s");
  }

  private static void rollDice(RollDiceHttpRequest rollDiceHttpRequest, int total) {
    for (int i = 0; i < total; i++) {
      HttpResponse<String> response = rollDiceHttpRequest.rollDice();
      System.out.println("Request roll dice -> " + response.body());
    }
  }
}
