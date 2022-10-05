package utils;

import java.util.Objects;

public class RollDiceUtil {

  private RollDiceUtil() {}

  public static final String BASE_URL = "https://roll-dice1.p.rapidapi.com/rollDice";

  public static final String API_KEY = Objects.requireNonNull(System.getenv("API_KEY"),
      "Environment API_KEY cannot be null.");

  public static final String API_HOST = Objects.requireNonNull(System.getenv("API_HOST"),
      "Environment API_HOST cannot be null.");

  public static final String NUMBER_OF_EXECUTIONS = Objects.requireNonNull(System.getenv("NUMBER_OF_EXECUTIONS"),
      "Environment NUMBER_OF_EXECUTIONS cannot be null.");
}
