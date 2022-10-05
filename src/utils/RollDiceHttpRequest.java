package utils;

import exceptions.HttpRollDiceException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public class RollDiceHttpRequest {

  private static final String BASE_URL = "https://roll-dice1.p.rapidapi.com/rollDice";
  private static final String API_KEY = Objects.requireNonNull(System.getenv("API_KEY"),
      "Environment API_KEY cannot be null.");
  private static final String API_HOST = Objects.requireNonNull(System.getenv("API_HOST"),
      "Environment API_HOST cannot be null.");

  public HttpResponse<String> rollDice() {
    try {
      HttpRequest request = HttpRequest.newBuilder()
          .headers("X-RapidAPI-Key", API_KEY, "X-RapidAPI-Host", API_HOST)
          .uri(URI.create(BASE_URL))
          .GET()
          .build();

      HttpClient client = HttpClient.newHttpClient();
      return client.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
      throw new HttpRollDiceException(
          "Could not possible send roll dice, because was occurred unexpected exception.");
    }
  }

}
