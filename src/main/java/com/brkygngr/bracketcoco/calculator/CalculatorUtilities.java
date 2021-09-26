package com.brkygngr.bracketcoco.calculator;

import java.math.BigInteger;

public final class CalculatorUtilities {

  private CalculatorUtilities() {
  }

  public static boolean numberSmallerOrEqual(BigInteger number, BigInteger compared) {
    return number.compareTo(compared) <= 0;
  }

  public static boolean numberSmallerThan(BigInteger number, BigInteger compared) {
    return number.compareTo(compared) < 0;
  }
}
