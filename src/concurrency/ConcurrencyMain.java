package concurrency;

import exceptions.InterruptedRollDiceException;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import utils.RollDiceHttpRequest;

public class ConcurrencyMain {

  public static void main(String[] args) {
    String numberOfTimes = Objects.requireNonNull(System.getenv("NUMBER_OF_TIMES"),
        "Environment NUMBER_OF_TIMES cannot be null.");

    System.out.println("Warm-up Java Virtual Machine...");

    RollDiceHttpRequest rollDiceHttpRequest = new RollDiceHttpRequest();
    for (int i = 0; i < 2; i++) {
      HttpResponse<String> response = rollDiceHttpRequest.rollDice();
      System.out.println("Request roll dice -> " + response.body());
    }

    System.out.println("Starting thread concurrency...");

    Instant start = Instant.now();

    RollDiceThread thread0 = new RollDiceThread("Thread0", Integer.parseInt(numberOfTimes)/10);
    RollDiceThread thread1 = new RollDiceThread("Thread1", Integer.parseInt(numberOfTimes)/10);
    RollDiceThread thread2 = new RollDiceThread("Thread2", Integer.parseInt(numberOfTimes)/10);
    RollDiceThread thread3 = new RollDiceThread("Thread3", Integer.parseInt(numberOfTimes)/10);
    RollDiceThread thread4 = new RollDiceThread("Thread4", Integer.parseInt(numberOfTimes)/10);
    RollDiceThread thread5 = new RollDiceThread("Thread5", Integer.parseInt(numberOfTimes)/10);
    RollDiceThread thread6 = new RollDiceThread("Thread6", Integer.parseInt(numberOfTimes)/10);
    RollDiceThread thread7 = new RollDiceThread("Thread7", Integer.parseInt(numberOfTimes)/10);
    RollDiceThread thread8 = new RollDiceThread("Thread8", Integer.parseInt(numberOfTimes)/10);
    RollDiceThread thread9 = new RollDiceThread("Thread9", Integer.parseInt(numberOfTimes)/10);

    thread0.start();
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
    thread5.start();
    thread6.start();
    thread7.start();
    thread8.start();
    thread9.start();

    try {
      thread0.join();
      thread1.join();
      thread2.join();
      thread3.join();
      thread4.join();
      thread5.join();
      thread6.join();
      thread7.join();
      thread8.join();
      thread9.join();
    } catch (InterruptedException e) {
      throw new InterruptedRollDiceException("Un unexpected error occurred with a one roll dice thread.");
    }

    Instant end = Instant.now();

    System.out.println("Finishing the main thread with a " + Duration.between(start, end).toSeconds() + "s");
  }

}
