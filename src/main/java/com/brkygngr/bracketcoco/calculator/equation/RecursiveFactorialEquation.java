package com.brkygngr.bracketcoco.calculator.equation;

import com.brkygngr.bracketcoco.validator.NumberValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

@Stateless
public class RecursiveFactorialEquation implements FactorialEquation {

  private final NumberValidator numberValidator;

  @Inject
  public RecursiveFactorialEquation(final NumberValidator numberValidator) {
    this.numberValidator = numberValidator;
  }

  @Override
  public long factorial(@Valid @PositiveOrZero int number) {
    if (numberValidator.invalid(number)) {
      numberValidator.throwError();
    }

    if (number == 0) {
      return 1;
    }

    if (number <= 2) {
      return number;
    }

    return number * factorial(number - 1);
  }
}
