package com.brkygngr.bracketcoco.calculator.equation;

import com.brkygngr.bracketcoco.calculator.CalculatorConstants;
import com.brkygngr.bracketcoco.calculator.CalculatorUtilities;
import com.brkygngr.bracketcoco.calculator.equation.qualifier.ParallelFactorial;
import com.brkygngr.bracketcoco.validator.NumberValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigInteger;
import java.util.stream.Stream;

@Stateless
@ParallelFactorial
public class ParallelFactorialEquation implements FactorialEquation {

  private final NumberValidator numberValidator;

  @Inject
  public ParallelFactorialEquation(final NumberValidator numberValidator) {
    this.numberValidator = numberValidator;
  }

  @Override
  public BigInteger factorial(@NotNull @PositiveOrZero final BigInteger number) {
    if (numberValidator.invalid(number)) {
      numberValidator.throwError();
    }

    if (CalculatorUtilities.numberSmallerThan(number, CalculatorConstants.BIG_INTEGER_TWO)) {
      return BigInteger.ONE;
    }

    return Stream
            .iterate(BigInteger.ONE, nextValue -> nextValue.add(BigInteger.ONE))
            .parallel()
            .limit(number.longValue())
            .reduce(BigInteger.ONE, BigInteger::multiply);
  }
}
