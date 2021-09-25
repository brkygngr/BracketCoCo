package com.brkygngr.bracketcoco.utility;

public final class MathUtility {

  private static final String ERROR_NEGATIVE_NUMBER = "Given number must be positive.";

  private MathUtility() {
  }

  public static int factorial(final int number) {
    if (number < 0) {
      throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER);
    }

    if (number == 0) {
      return 1;
    }

    if (number <= 2) {
      return number;
    }

    return number * factorial(number - 1);
  }

  public static int catalan(final int number) {
    if (number < 0) {
      throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER);
    }

    int numerator = factorial(2 * number);
    int denominator = factorial(number + 1) * factorial(number);

    return numerator / denominator;
  }
}
