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

      System.out.println("Request roll dice " + threadName + " -> " + response.body());
    } catch (IOException | InterruptedException e) {
      throw new HttpRollDiceException(
          "Could not possible send roll dice, because was occurred unexpected exception.");
    }
  }

  public void rollDice(String threadName, long timeSleep, int numberOfExecutions) {
    long totalTime = 0L;
    long count = 0;

    do {
      Instant start = Instant.now();
      request(Thread.currentThread().getName());
      Instant end = Instant.now();

      if(count >= WARM_UP) {
        totalTime += Duration.between(start, end).toMillis();
      }

      try {
        Thread.sleep(timeSleep);
      } catch (InterruptedException e) {
        throw new HttpRollDiceException("Could not possible sleep thread.");
      }

      count += 1;
    } while (count <= (numberOfExecutions + WARM_UP));

    System.out.println("Finishing the " + threadName + " with " + totalTime + " ms");
  }
}
