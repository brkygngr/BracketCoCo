package com.brkygngr.bracketcoco.validator;

import com.brkygngr.bracketcoco.constant.ErrorMessageConstant;

public class PositiveNumberValidator {

  public static void throwErrorIfNegative(int number) {
    if (number < 0) {
      throw new IllegalArgumentException(ErrorMessageConstant.NEGATIVE_NUMBER);
    }
  }
}
