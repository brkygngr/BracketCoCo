package com.brkygngr.bracketcoco.calculator.equation;

import com.brkygngr.bracketcoco.calculator.CalculatorConstants;
import com.brkygngr.bracketcoco.calculator.equation.qualifier.ParallelFactorial;
import com.brkygngr.bracketcoco.validator.NumberValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigInteger;

@Stateless

public class FactorialCatalanNumberEquation implements CatalanNumberEquation {

  private final NumberValidator numberValidator;

  private final FactorialEquation factorialEquation;

  @Inject
  public FactorialCatalanNumberEquation(final NumberValidator numberValidator, @ParallelFactorial final FactorialEquation factorialEquation) {
    this.numberValidator = numberValidator;
    this.factorialEquation = factorialEquation;
  }

  @Override
  public BigInteger catalanNumber(@NotNull @PositiveOrZero final BigInteger pairCount) {
    if (numberValidator.invalid(pairCount)) {
      numberValidator.throwError();
    }

    BigInteger numerator = factorialEquation.factorial(pairCount.multiply(CalculatorConstants.BIG_INTEGER_TWO));
    BigInteger denominator = factorialEquation.factorial(pairCount.add(BigInteger.ONE)).multiply(factorialEquation.factorial(pairCount));

    return numerator.divide(denominator);
  }
}
