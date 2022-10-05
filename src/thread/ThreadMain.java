package thread;

import exceptions.InterruptedRollDiceException;
import java.time.Duration;
import java.time.Instant;
import utils.HttpRollDice;
import utils.RollDiceUtil;

public class ThreadMain {

  private static final int NUMBER_OF_THREADS = 10;

  public static void main(String[] args) {
    System.out.println("Warm-up Java Virtual Machine...");

    HttpRollDice httpRollDice = new HttpRollDice();
    httpRollDice.rollDice("MainThread", Integer.parseInt(RollDiceUtil.NUMBER_OF_EXECUTIONS));

    System.out.println("Starting thread concurrency...");

    Instant start = Instant.now();

    RollDiceThread thread0 = new RollDiceThread("Thread0", Integer.parseInt(RollDiceUtil.NUMBER_OF_EXECUTIONS) / NUMBER_OF_THREADS);
    RollDiceThread thread1 = new RollDiceThread("Thread1", Integer.parseInt(RollDiceUtil.NUMBER_OF_EXECUTIONS) / NUMBER_OF_THREADS);
    RollDiceThread thread2 = new RollDiceThread("Thread2", Integer.parseInt(RollDiceUtil.NUMBER_OF_EXECUTIONS) / NUMBER_OF_THREADS);
    RollDiceThread thread3 = new RollDiceThread("Thread3", Integer.parseInt(RollDiceUtil.NUMBER_OF_EXECUTIONS) / NUMBER_OF_THREADS);
    RollDiceThread thread4 = new RollDiceThread("Thread4", Integer.parseInt(RollDiceUtil.NUMBER_OF_EXECUTIONS) / NUMBER_OF_THREADS);
    RollDiceThread thread5 = new RollDiceThread("Thread5", Integer.parseInt(RollDiceUtil.NUMBER_OF_EXECUTIONS) / NUMBER_OF_THREADS);
    RollDiceThread thread6 = new RollDiceThread("Thread6", Integer.parseInt(RollDiceUtil.NUMBER_OF_EXECUTIONS) / NUMBER_OF_THREADS);
    RollDiceThread thread7 = new RollDiceThread("Thread7", Integer.parseInt(RollDiceUtil.NUMBER_OF_EXECUTIONS) / NUMBER_OF_THREADS);
    RollDiceThread thread8 = new RollDiceThread("Thread8", Integer.parseInt(RollDiceUtil.NUMBER_OF_EXECUTIONS) / NUMBER_OF_THREADS);
    RollDiceThread thread9 = new RollDiceThread("Thread9", Integer.parseInt(RollDiceUtil.NUMBER_OF_EXECUTIONS) / NUMBER_OF_THREADS);

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
