package com.brkygngr.bracketcoco.calculator.combination;

import com.brkygngr.bracketcoco.calculator.equation.CatalanNumberEquation;
import com.brkygngr.bracketcoco.validator.NumberValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

@Stateless
public class CatalanBracketCombinationCalculator implements BracketCombinationCalculator {

  private final NumberValidator numberValidator;

  private final CatalanNumberEquation catalanNumberEquation;

  @Inject
  public CatalanBracketCombinationCalculator(final NumberValidator numberValidator, final CatalanNumberEquation catalanNumberEquation) {
    this.numberValidator = numberValidator;
    this.catalanNumberEquation = catalanNumberEquation;
  }

  @Override
  public int totalCombinations(@Valid @PositiveOrZero final int pairCount) {
    if (numberValidator.invalid(pairCount)) {
      numberValidator.throwError();
    }

    if (pairCount == 0) {
      return 0;
    }

    return catalanNumberEquation.catalanNumber(pairCount);
  }
}
