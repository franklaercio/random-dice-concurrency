package utils;

import exceptions.HttpRollDiceException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRollDice {

  private HttpResponse<String> requestRollDice() {
    try {
      HttpRequest request = HttpRequest.newBuilder()
          .headers("X-RapidAPI-Key", RollDiceUtil.API_KEY, "X-RapidAPI-Host", RollDiceUtil.API_HOST)
          .uri(URI.create(RollDiceUtil.BASE_URL))
          .GET()
          .build();

      HttpClient client = HttpClient.newHttpClient();
      return client.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
      throw new HttpRollDiceException(
          "Could not possible send roll dice, because was occurred unexpected exception.");
    }
  }

  public void rollDice(String threadName, int numberOfExecutions) {
    for (int i = 0; i < numberOfExecutions; i++) {
      HttpResponse<String> response = requestRollDice();
      System.out.println("Request roll dice " + threadName + " -> " + response.body());
    }
  }
}
