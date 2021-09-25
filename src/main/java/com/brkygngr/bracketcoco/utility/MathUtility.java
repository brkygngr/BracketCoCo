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

  public static int catalan(final int pairCount) {
    if (pairCount < 0) {
      throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER);
    }

    int numerator = factorial(2 * pairCount);
    int denominator = factorial(pairCount + 1) * factorial(pairCount);

    return numerator / denominator;
  }
}
