package com.brkygngr.bracketcoco.calculator.equation;

import com.brkygngr.bracketcoco.calculator.CalculatorConstants;
import com.brkygngr.bracketcoco.calculator.CalculatorUtilities;
import com.brkygngr.bracketcoco.validator.NumberValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigInteger;

@Deprecated
@Stateless
public class RecursiveFactorialEquation implements FactorialEquation {

  private final NumberValidator numberValidator;

  @Inject
  public RecursiveFactorialEquation(final NumberValidator numberValidator) {
    this.numberValidator = numberValidator;
  }

  @Override
  public BigInteger factorial(@NotNull @PositiveOrZero final BigInteger number) {
    if (numberValidator.invalid(number)) {
      numberValidator.throwError();
    }

    if (number.equals(BigInteger.ZERO)) {
      return BigInteger.ONE;
    }

    if (CalculatorUtilities.numberSmallerOrEqual(number, CalculatorConstants.BIG_INTEGER_TWO)) {
      return number;
    }

    return number.multiply(factorial(number.subtract(BigInteger.ONE)));
  }
}
