package com.brkygngr.bracketcoco.utility;

import com.brkygngr.bracketcoco.validator.PositiveNumberValidator;

public final class MathUtility {

  private MathUtility() {
  }

  public static int factorial(final int number) {
    PositiveNumberValidator.throwErrorIfNegative(number);

    if (number == 0) {
      return 1;
    }

    if (number <= 2) {
      return number;
    }

    return number * factorial(number - 1);
  }

  public static int catalan(final int pairCount) {
    PositiveNumberValidator.throwErrorIfNegative(pairCount);

    int numerator = factorial(2 * pairCount);
    int denominator = factorial(pairCount + 1) * factorial(pairCount);

    return numerator / denominator;
  }
}
