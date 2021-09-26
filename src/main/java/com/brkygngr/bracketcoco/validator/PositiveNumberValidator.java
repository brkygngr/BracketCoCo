package com.brkygngr.bracketcoco.validator;

import javax.ejb.Stateless;

@Stateless
public class PositiveNumberValidator implements NumberValidator {

  public final String NEGATIVE_NUMBER = "Given number must be positive.";

  @Override
  public boolean valid(int number) {
    return number >= 0;
  }

  @Override
  public boolean invalid(int number) {
    return !valid(number);
  }

  @Override
  public void throwError() {
    throw new IllegalArgumentException(NEGATIVE_NUMBER);
  }
}
