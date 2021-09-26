package com.brkygngr.bracketcoco.calculator.equation;

import com.brkygngr.bracketcoco.validator.NumberValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

@Stateless
public class FactorialCatalanNumberEquation implements CatalanNumberEquation {

  private final NumberValidator numberValidator;

  private final FactorialEquation factorialEquation;

  @Inject
  public FactorialCatalanNumberEquation(final NumberValidator numberValidator, final FactorialEquation factorialEquation) {
    this.numberValidator = numberValidator;
    this.factorialEquation = factorialEquation;
  }

  @Override
  public long catalanNumber(@Valid @PositiveOrZero final int pairCount) {
    if (numberValidator.invalid(pairCount)) {
      numberValidator.throwError();
    }

    long numerator = factorialEquation.factorial(2 * pairCount);
    long denominator = factorialEquation.factorial(pairCount + 1) * factorialEquation.factorial(pairCount);

    return numerator / denominator;
  }
}
