package utils;

import exceptions.HttpRollDiceException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.Instant;

public class RollDiceUtils {

  public static final int WARM_UP = 2;

  private void request(String threadName) {
    try {
      HttpRequest request = HttpRequest.newBuilder()
          .headers("X-RapidAPI-Key", ConstantsUtils.API_KEY, "X-RapidAPI-Host", ConstantsUtils.API_HOST)
          .uri(URI.create(ConstantsUtils.BASE_URL))
          .GET()
          .build();

      HttpClient client = HttpClient.newHttpClient();
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      System.out.println("[" + threadName + "] Request roll dice -> " + response.body());
    } catch (IOException | InterruptedException e) {
      throw new HttpRollDiceException(
          "Could not possible send roll dice, because was occurred unexpected exception.");
    }
  }

  public void rollDice(String threadName, long timeSleep, int numberOfExecutions) {
    long warmUpTime = 0L;

    for (int i = 1; i <= numberOfExecutions + WARM_UP; i++) {
      Instant start = Instant.now();
      request(Thread.currentThread().getName());
      Instant end = Instant.now();

      if(i == WARM_UP) {
        warmUpTime += Duration.between(start, end).toMillis();
        System.out.println("[" + threadName + "] Warm up duration is a " + warmUpTime + " ms");
      }

      try {
        Thread.sleep(timeSleep);
      } catch (InterruptedException e) {
        throw new HttpRollDiceException("Could not possible sleep thread.");
      }
    }
  }
}
