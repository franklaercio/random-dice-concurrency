package thread;

import exceptions.InterruptedRollDiceException;
import utils.ConstantsUtils;

public class ThreadMain {

  private static final int NUMBER_OF_THREADS = 10;
  private static final long FIVE_HUNDRED_MILLISECONDS = 500L;

  public static void main(String[] args) {

    System.out.println("Starting the " + Thread.currentThread().getName() + " concurrency.");

    RollDiceThread thread0 = new RollDiceThread("Thread0", (ConstantsUtils.NUMBER_OF_EXECUTIONS / NUMBER_OF_THREADS), FIVE_HUNDRED_MILLISECONDS);
    RollDiceThread thread1 = new RollDiceThread("Thread1", (ConstantsUtils.NUMBER_OF_EXECUTIONS / NUMBER_OF_THREADS), FIVE_HUNDRED_MILLISECONDS);
    RollDiceThread thread2 = new RollDiceThread("Thread2", (ConstantsUtils.NUMBER_OF_EXECUTIONS / NUMBER_OF_THREADS), FIVE_HUNDRED_MILLISECONDS);
    RollDiceThread thread3 = new RollDiceThread("Thread3", (ConstantsUtils.NUMBER_OF_EXECUTIONS / NUMBER_OF_THREADS), FIVE_HUNDRED_MILLISECONDS);
    RollDiceThread thread4 = new RollDiceThread("Thread4", (ConstantsUtils.NUMBER_OF_EXECUTIONS / NUMBER_OF_THREADS), FIVE_HUNDRED_MILLISECONDS);
    RollDiceThread thread5 = new RollDiceThread("Thread5", (ConstantsUtils.NUMBER_OF_EXECUTIONS / NUMBER_OF_THREADS), FIVE_HUNDRED_MILLISECONDS);
    RollDiceThread thread6 = new RollDiceThread("Thread6", (ConstantsUtils.NUMBER_OF_EXECUTIONS / NUMBER_OF_THREADS), FIVE_HUNDRED_MILLISECONDS);
    RollDiceThread thread7 = new RollDiceThread("Thread7", (ConstantsUtils.NUMBER_OF_EXECUTIONS / NUMBER_OF_THREADS), FIVE_HUNDRED_MILLISECONDS);
    RollDiceThread thread8 = new RollDiceThread("Thread8", (ConstantsUtils.NUMBER_OF_EXECUTIONS / NUMBER_OF_THREADS), FIVE_HUNDRED_MILLISECONDS);
    RollDiceThread thread9 = new RollDiceThread("Thread9", (ConstantsUtils.NUMBER_OF_EXECUTIONS / NUMBER_OF_THREADS), FIVE_HUNDRED_MILLISECONDS);

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

    System.out.println("Finishing the " + Thread.currentThread().getName() + " concurrency.");
  }

}
