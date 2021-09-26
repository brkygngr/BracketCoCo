package com.brkygngr.bracketcoco.validator;

import com.brkygngr.bracketcoco.calculator.CalculatorUtilities;

import javax.ejb.Stateless;
import java.math.BigInteger;

@Stateless
public class PositiveNumberValidator implements NumberValidator {

  private static final String NEGATIVE_NUMBER = "Given number must be positive.";

  @Override
  public boolean valid(BigInteger number) {
    return CalculatorUtilities.numberSmallerOrEqual(BigInteger.ZERO, number);
  }

  @Override
  public boolean invalid(BigInteger number) {
    return !valid(number);
  }

  @Override
  public void throwError() {
    throw new IllegalArgumentException(NEGATIVE_NUMBER);
  }
}
