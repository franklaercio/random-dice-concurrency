package concurrency;

import java.net.http.HttpResponse;
import utils.RollDiceHttpRequest;

public class RollDiceThread extends Thread {

  private final int numberOfTimes;

  public RollDiceThread(String name, int numberOfTimes) {
    super(name);
    this.numberOfTimes = numberOfTimes;
  }

  @Override
  public void run() {
    RollDiceHttpRequest rollDiceHttpRequest = new RollDiceHttpRequest();

    for (int i = 0; i < numberOfTimes; i++) {
      HttpResponse<String> response = rollDiceHttpRequest.rollDice();
      System.out.println("Request roll dice " + this.getName() + " -> " + response.body());
    }
  }
}